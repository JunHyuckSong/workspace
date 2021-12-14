<%@page import="java.sql.ResultSet"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;  // 위 두 코드는 JDBCUtil.java와 똑같음.
	
	// JNDI 시작!!
	try{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:comp/env"); 
		DataSource ds = (DataSource)envContext.lookup("jdbc/orcl");
		
		conn = ds.getConnection(); //dpcp에 이미 존재하는 커넥션을 받는다. 일일히 서버에 접근할 필요가 사라진것.
		String sql = "insert into board values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(request.getParameter("bid")));
		pstmt.setString(2, request.getParameter("writer"));
		pstmt.setString(3, request.getParameter("content"));
		pstmt.executeUpdate();
		// 연결을 해제할 필요없음 ---> ds가 알아서 반납해주니까~~
	}catch(Exception e){
		System.out.println("예외발생1");
	}
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>조회</h2>
	
	<form action="dbcpTest2.jsp" method="post">
		<table border="1">
			<tr>
				<td>BID</td>
				<td><input type="number" name="bid"></td>
			</tr>
			<tr>
				<td>WRITER</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="제출"></td>	
			</tr>
		</table>
	</form>
	<br>
	<hr>
	<br>
	
	<h2>데이터 목록</h2>
	<hr>
	
	<%
		try{
			String sql = "select writer from board";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				out.println(rs.getString(1)+"<br>");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			System.out.println("예외발생2");
		}
	
	
	
	%>
	
	
</body>
</html>