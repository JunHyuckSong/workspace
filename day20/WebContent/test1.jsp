<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="testController.jsp" method="post">
		<input type="hidden" name="action" value="insert">
		<table border="1">
			<tr>
				<td>BID</td>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<td>WRITER</td>
				<td><input type="text" name="mpw"></td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="제출"></td>	
			</tr>
		</table>
	</form>
	<br>
	<hr>
	<br>
	<a href="testController.jsp?action=main">목록보기</a>
	
</body>
</html>