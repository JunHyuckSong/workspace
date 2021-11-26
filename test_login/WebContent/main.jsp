<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mb = (MemberVO)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인화면</h1>
	<table border="1">
		<tr>
			<td>아이디명</td>
			<td><%=mb.getId() %></td>
		</tr>
	</table>
</body>
</html>