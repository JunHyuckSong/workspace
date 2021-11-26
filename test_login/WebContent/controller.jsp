<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="model.MemberDAO"/>
<jsp:useBean id="vo" class="model.MemberVO"/>
<jsp:setProperty property="*" name="vo"/>


<%
	String action = request.getParameter("action");

	if(action.equals("login")){
		pageContext.forward("login.jsp");
	}else if(action.equals("check")){
		//out.println(vo); //로깅 결과 vo에 잘 set되는 것을 확인
		if(dao.check(vo)){
			MemberVO user = vo;
			session.setAttribute("user", user);
			//out.println("<script>alert('환영합니다.')</script>");
			response.sendRedirect("controller.jsp?action=main");
			
		}else{
			String msg = "올바르지 않은 계정입니다.";
			request.setAttribute("msg", msg);
			pageContext.forward("login.jsp");
		}
	}else if(action.equals("main")){
		pageContext.forward("main.jsp");
	}else{
		out.println("<script>alert('action파라미터의 값이 올바르지 않습니다.')</script>");
	}
	
%>