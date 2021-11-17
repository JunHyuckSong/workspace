<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="day03.Calc"%>
<%-- <jsp:useBean id=""></jsp:useBean> == new 생성자(); --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1.GET 현재페이지를 요청
		 2.현재페이지가 브라우저에 출력
		 3.POST로 계산기능을 요청
		 4.작업한대로 겨롸가 브라우저 출력 -->
	<%
		//스크립트릿
		int res = 0;//초기값 설정
		if(request.getMethod().equals("POST")){
			// 1. 계산기능에 필요한 값들을 추출
			int num1 = Integer.parseInt(request.getParameter("num1")); //request는 내장객체이므로 따로 선언하지 않아도 됨
			//형변환을 해야하는데, 대상이 null이다 --> num1이라는 이름의 파라미터가 없음
			int num2 = Integer.parseInt(request.getParameter("num2"));
			String op = request.getParameter("op");
			
			// 계산기능을 수행
			/* if(op.equals("+")) {
				res = num1 + num2;
			}
			else {
				res = num1 - num2;
			} */
			
			Calc calc = new Calc(num1, num2, op);
			res = calc.getRes();
		}
		// 출력
		// --> 밑에서 출력을 하니까 따로 코드작성이 필요하지 않다.
	%>
	
	<form method="post"> <!-- 여기서는 서블릿을 사용하지 않을것이므로 action="/day02/CalcServlet"는 쓰지 않는다. -->
	   <input type="text" name="num1">
	   <select name="op">
	      <option selected>+</option>
	      <option>-</option>
	   </select>
	   <input type="text" name="num2">
	   <input type="submit" value="계산하기">
	</form>
	<hr>
	<h2>계산결과는 <%= res %>입니다</h2>
	
</body>
</html>