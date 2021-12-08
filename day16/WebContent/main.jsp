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
	
		<c:forEach items="${datas}" var="v">
			<c:set var="bvo" value="${v.board}"/>
			${bvo.mid} <a href="board_controller.jsp?action=fav&cnt=${cnt}&bid=${bvo.bid}">[좋아요]</a>
			<c:forEach var="vv" items="${v.rdatas}">
				${vv.rid} ${vv.bid} ${vv.mid} ${vv.rmsg} <br>
			</c:forEach>
			<hr>
		</c:forEach>	
	
	<hr>
	
	
	<!-- "board_controller.jsp?action=fav" -->
	<!-- 이렇게 만들면 cnt파라미터를 보내주지 않았기때문에 null이므로 2로 초기화될 수 있다 -->
	<!-- 참고할 것!! URL로 보내는 속석은 Parameter속성 -->
	
	<a href="controller.jsp?action=main&cnt=${cnt+2}">[더보기]</a>
</body>
</html>