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
	<jsp:useBean id="nl" class="day12.Selection" scope="session"/>
	<form action="showResult.jsp" method="post">
		<select name= "cname">
			<c:forEach var="v" items="${nl.nameList}">
				<option>${v}</option>
			</c:forEach>
		</select>
		<input type="submit" value="캐릭터 선택완료">
	</form>
</body>
</html>