<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del() {
		if(confirm("정말 삭제하시겠습니까?")){
			//document.formA.action.value = "delete";
			//document.formA.submit();
			var action = document.querySelector('.action')
			action.value = "delete";
			document.formA.submit();
		}
		else{
			return;
		}
	}
</script>
</head>
<body>
	<c:if test="${data.id==null}">
		<h1>출력할 데이터가 없습니다</h1>
	</c:if>
	<c:if test="${data.id!=null}">	
		<form action="controller.jsp" method="post" name="formA">	
			<input type="hidden" class="action" name="action" value="update">
			<input type="hidden" name="id" value="${data.id}">
			<table border="1">
				<tr>
					<td>작성자</td>
					<td><input type="text" name="username" value=" ${data.username}"></td>
				</tr>
				<tr>
					<td>글 제목</td>
					<td><input type="text" name="title" value="${data.title}"></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><input type="text" name="content" value="${data.content}"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="변경하기 "><input type="button" value="삭제하기 " onclick="del()"></td>
				</tr>
			</table>	
		</form>
	</c:if>

</body>
</html>