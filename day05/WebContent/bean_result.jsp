<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="lb" class="day05.loginBean"/>  
<jsp:setProperty property="*" name="lb"/>  
 
 <%
 	System.out.println(lb); // lb를 사용할 수 있다..!!!
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(lb.check()){
			out.println("로그인 성공");
		}else{
			out.println("로그인 실패");
		}
	
	%>
	
	<jsp:getProperty property="uid" name="lb"/>
	<jsp:getProperty property="upw" name="lb"/>
	<%=lb.getUid() %>
	<%=lb.getUpw() %>
</body>
</html>