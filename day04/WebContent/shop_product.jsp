<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");	
	session.setAttribute("uid", request.getParameter("uid"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1><%=session.getAttribute("uid") %>님,환영합니다!</h1>
	<h2>상품 목록</h2>
	<hr>
	<form action="shop_add.jsp" method="post">
		<select name = "product" >
			<option>꿀잼 티모</option>
			<option>작은악마 티모</option>
			<option>정찰대 티모</option>
			<option>판다 티모</option>
			<option>우주비행사 티모</option>
		</select>
		<input type="submit" value="장바구니에 추가" >
	</form>
	<hr>
	<a href="shop_result.jsp">결제하기</a>
	
	
	
</body>
</html>