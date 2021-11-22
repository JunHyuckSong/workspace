<%@page import="day06.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<jsp:useBean id="mdb" class="day06.MemberDataBean" scope="application"/>
<%
	request.setCharacterEncoding("UTF-8");
	 String sname = request.getParameter("sname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		 MemberBean smd = mdb.search(sname);
		if(smd == null){
			out.println("검색결과가 없습니다.");
		}
	%>
	<table border="1">
		<tr>
			<td>이름</td><td>아이디</td><td>비밀번호</td>
		</tr>
		<tr>
			<td><%=smd.getUname() %></td><td><%=smd.getUid() %></td><td><%=smd.getUpw() %></td>
		</tr>
	</table>
</body>
</html>