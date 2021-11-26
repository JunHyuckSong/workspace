<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  // index페이지는 극단적으로 아무것도 필요없다
									   // int = 10	이랑 일맥상통
	pageContext.forward("controller.jsp?action=main"); //pageContext는 내장객체
%>