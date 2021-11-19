<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선택한 상품 목록</h1>
	<hr>
	<%
	//목록은 Java 코드의 개입이 필요하다!!!
		ArrayList<String> datas = (ArrayList)session.getAttribute("datas");
		if(datas == null ){ // 상품목록(datas)에 담긴 상품이 없다면..
			out.println("선택한 상품이 없습니다");
		}else{
			out.println("<ol>");
			for(String v : datas){
				//System.out.println(v); //콘솔출력일 경우
				out.println("<li>" + v + "</li><br>");
			}
			out.println("</ol>");				
		}
		
	%>
</body>
</html>