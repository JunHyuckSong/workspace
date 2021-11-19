<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%-- <%
	// sns_add는 보여지는 페이지가 아니므로 스크릿트렛만 필요
	request.setCharacterEncoding("UTF-8");
	String msg = request.getParameter("msg");
	
	ArrayList<String> datas = (ArrayList)application.getAttribute("datas");
	if(datas == null){//장바구니가 매번 생성되는 것이 아니라, 처음 장바구니에 상품을 추가할 떄만 1회 생성됨
    	datas = new ArrayList<>();
    	application.setAttribute("datas", datas);    		
	}
	Date date = new Date();
	datas.add(msg + "   ["+date+"]");
	
	response.sendRedirect("sns_list.jsp"); // 리스트보기 버튼을 누른 행동
	
%> --%>

<%
   request.setCharacterEncoding("UTF-8");

   String msg=request.getParameter("msg");
   
   ArrayList<String> datas=(ArrayList)application.getAttribute("datas");
   if(datas==null){
      datas=new ArrayList<String>();
      application.setAttribute("datas", datas);
   }
   
   Date date=new Date();
   datas.add(session.getAttribute("uid")+ "님으로부터 "+ msg+"  ["+date+"]");
   			 //세션에 접속해서 댓글을 남긴 uid를 application에 저장!!
   
   response.sendRedirect("sns_list.jsp"); // == 리스트보기 버튼을 누른 행동
%>