<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ol>
	<c:forTokens items="23234-1231-13123-123-31254-123" delims="-" var="v">
		<li>${v}</li>
	</c:forTokens>
	</ol>
</body>
</html>