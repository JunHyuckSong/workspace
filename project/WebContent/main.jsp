<%@page import="java.util.ArrayList"%>
<%@page import="model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="datas" scope="request" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글 번호</th><th>글 제목</th><th>작성자</th>
		</tr>
		<%
			for(BoardVO v : (ArrayList<BoardVO>)datas){ // datas는 ArrayList, 즉 object타입을 반환하므로 형변환이 필요하다((ArrayList<BoardVO>))
		%>
		<tr>
			<td><a href="controller.jsp?action=board&bid=<%=v.getBid()%>"><%=v.getBid() %></a></td><td><%=v.getTitle() %></td><td><%=v.getWriter() %></td>
		</tr>
		<% 
		
			}
		%>		
	
	</table>
	
	<hr>
	
	<a href="form.jsp">글 작성하기</a>
	
</body>
</html>