<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	if(session.getAttribute("uid")==null){
		session.setAttribute("uid",request.getParameter("uid"));	
	}
	/* if(request.getParameter("uid")==null) 이것을 조건으로 해도 된다. */

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="sns_add.jsp" method="post">
		<%=session.getAttribute("uid")%>님 : <input type="text" name="msg"><input type="submit" value="글작성">
	</form>
	<hr>
	<%
		ArrayList<String> datas = (ArrayList)application.getAttribute("datas");//댓글의 경우 세션이 만료되어도 계속 유지되어야 하고 공통의 데이터이므로 application을 사용!!
		if(datas!=null){
			for(String data : datas){
				out.println(data + "<br>");
			}			
		}else{
			out.println("채팅기록이 없습니다. <br>");
		}
	%>

</body>
</html>