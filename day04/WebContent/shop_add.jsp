<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String product = request.getParameter("product");
    	
    	ArrayList<String> datas = (ArrayList)session.getAttribute("datas");
    	if(datas == null){//장바구니가 매번 생성되는 것이 아니라, 처음 장바구니에 상품을 추가할 떄만 1회 생성됨
	    	datas = new ArrayList<>();
	    	session.setAttribute("datas", datas);    		
    	}
    	
    	datas.add(product);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		alert("<%=product%>가 장바구니에 추가되었습니다!");
		history.go(-1);
	</script>
</body>
</html>