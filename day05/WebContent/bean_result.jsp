<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="lb" class="day05.loginBean"/> 
<!-- lb는 생성될 객체(인스턴스)의 이름 / 객체가 생성될 자바빈 클래스명(패키지명 포함 풀네임)--> 
<jsp:setProperty property="*" name="lb"/>  
<!-- lb는 생성한 객체(인스턴스)의 이름 / property의 경우 form에서 넘어오는
	  파라미터의 이름은 자바빈 프로퍼티의 이름과 정확히 일치해야함, 개수 또한 일치해야함   -->
 
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