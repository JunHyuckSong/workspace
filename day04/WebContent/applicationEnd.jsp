<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int cnt = (Integer)(application.getAttribute("cnt")); 
	cnt++;
	application.setAttribute("cnt", cnt);// 새로 cnt값을 설정해줘야 application 내부 cnt값이 증가한 값이 설정된다.
%>

<%=application.getAttribute("name") %>님, 투데이 방문자 수는
<%=cnt %>명입니다.
</body>
</html>