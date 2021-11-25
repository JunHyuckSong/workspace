<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    <%
    	request.setCharacterEncoding("UTF-8");
	    String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="song";
		String password="1234";
		
		String sql_selectAll = "select * from board"; //pstmt 스타일
		String sql_insert = "insert into board values((select nvl(max(bid),0)+1 from board),?,?)";//pstmt 스타일
														//bid의 max값에 1을 더해줘서 bid를 정해준다 --> 사용자가 pk를 건드리게 해서는 안된다.
		Connection conn = null;
		PreparedStatement pstmt = null; // 실무에서는 Statement보다 많이 쓰인다.
		
		try {
			//1.JDBC -JVM 연결
			Class.forName(driver);
			//2.DB 접속
			conn = DriverManager.getConnection(url, user, password);
			
			// 이 지점에 insert SQL을 pstmt통해 추가해줘야함
			if(request.getParameter("writer")!=null){ // request를 통해 데이터가 넘어올때만 실행시키자. 조건을 걸어주지 않으면 매번 실행된다.
				String uname = request.getParameter("writer");
				String content = request.getParameter("content");
				
				pstmt = conn.prepareStatement(sql_insert);
				pstmt.setString(1, uname);
				pstmt.setString(2, content); 
				pstmt.executeUpdate();				
			}
			// submit을 통해 DB에 정보가 추가되었다면  sql_selectAll요청이 오기전에 추가해주어야 하므로 앞단에 코드가 배치되어야 한다.
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		작성자 : <input type="text" name="writer"> 내용 : <input type="text" name="content"> <input type="submit" value="게시글 등록">
	</form>
	
	<hr>
	
	<h2>게시글 목록</h2>
	<%
			// 현재 DB에 저장되어 있는 정보를 모두 출력하기 위한 part(sql_selectAll)
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery(); // executeQuery()는 select처럼 조회할 때만!!!!!!!!!!!
			while(rs.next()){
				out.println(rs.getInt("bid")+". " + rs.getString("writer")+"님 : "+rs.getString("content")+ "<br>");
			}
			rs.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	%>
	
</body>
</html>