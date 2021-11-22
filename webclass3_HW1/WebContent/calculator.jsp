<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="cal" class="webclass3_HW1.Calc"></jsp:useBean>
<jsp:setProperty property="*" name="cal"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=cal.getNum1()%><%=cal.getOp()%><%=cal.getNum2()%></h1>
	<h1>계산 결과는 <%=cal.calc() %></h1>
	<input type="button" id="re-btn" value="돌아가기">
	
	<script type="text/javascript">
		var re_btn = document.querySelector("#re-btn");
		re_btn.addEventListener("click", function() {
			console.log("수행");
			location.href="cal.html";
			<%-- <%
				response.sendRedirect("cal.html");
			%> --%>
		});
	</script>
</body>
</html>