<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<td><%=request.getParameter("uid") %></td>
		</tr>
		<tr>
			<td>관심언어</td>
			<td><%=request.getParameter("ln") %></td>
		</tr>
		<tr>
			<td>좋아하는 과일</td>
			<td>
				<%
					String[] datas = request.getParameterValues("ff"); 
					if(datas!=null){
						for(String v : datas)
							//System.out.println(v);//콘솔에 출력인 경우
							out.println(v + "<br>"); // 화면에 출력하는 경우, out 내장객체 사용												
					}else{
						out.println("좋아하는 과일이 없습니다.");
					}
					
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="보내기"></td>
		</tr>
	</table>
	<hr>
	<a href="start.html">돌아가기</a>
</body>
</html>