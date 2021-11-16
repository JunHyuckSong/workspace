<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>현재 시간은 <%=new Date() %></h1>

<%
	System.out.println(out); // 내장객체로 out이 저장됨.
%>

</body>
</html>