<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mdao" class="model.MemberDAO"/>
<jsp:useBean id="mvo" class="model.MemberVO"/>
<jsp:setProperty property="*" name="mvo"/>
<%
	
	String action = request.getParameter("action");
	
	if(action.equals("main")){
		ArrayList<MemberVO> datas = mdao.select(mvo); // mvo가 매개변수로 필요한 이유?
		request.setAttribute("datas", datas);
		pageContext.forward("test2.jsp");
	}else if(action.equals("insert")){
		if(mdao.insert(mvo)){
			response.sendRedirect("testController.jsp?action=main");
		}else{
			System.out.println("inset 액션에서 문제발생");
		}
	}
	
	
%>