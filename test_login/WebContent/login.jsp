<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errMsg = (String)request.getAttribute("msg");
	if(errMsg==null){
		errMsg = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인페이지</h1>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="action" value="check">
		아이디 입력 : <input type="text" name="id">
		비밀번호 입력 : <input type="password" name="password">
		<input type="submit" value="로그인"><br>
		<div><%=errMsg %></div>
	</form>
</body>
</html>