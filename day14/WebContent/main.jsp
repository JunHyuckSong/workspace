<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>

	<table border="1">
	<tr>
		<th>글번호</th><th>작성자</th><th>글제목</th>
	</tr>
		<c:forEach var="v" items="${datas}">
			<tr>
				<td><a href="controller.jsp?action=board&id=${v.id}">${v.id}</a></td><td>${v.username}</td><td>${v.title}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="form.jsp">글 쓰러가기</a>
	
</html>