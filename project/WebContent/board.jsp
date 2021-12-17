<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<script type="text/javascript">
	function del() {
		ans = confirm("내용은 복구되지 않흡니다. 정말 삭제하시겠습니까?");
		if(ans==true){
			/* document.formA.action.value='delete';
			document.formA.submit();//<input type="text" name="action" value="delete">로 바꿔서 controller로 submit 한다. */
			location.href= "delete.do?bid="+${data.bid};
		}else{
			return;
		}
	}
</script>
</head>
<body>
<form action="update.do" method="post" name="formA">
	<input type="hidden" name="bid" value="${data.bid}">
	<table border="1">
		<tr>
			<td>글 제목</td>
			<td><input type="text" name="title" value="${data.title}"></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td><input type="text" name="content" value="${data.content}"><td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="wirter" value="${data.writer}"><td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="글 내용 변경하기"><td>
		</tr>
	</table>
</form>
<a href="delete.do?bid=${data.bid}">해당 게시글 삭제하기</a>
<hr>
<a href="main.do">메인페이지로 돌아가기</a>
</body>
</html>