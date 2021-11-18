<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	response.sendRedirect("z.jsp");
	//페이지 제어권을 z.jsp로 넘겨줌
	//요청헤더(==데이터)를 교체해버림(a.jsp에서 보낸 request가 새로운 request(=null)가 되어버림!)
%>