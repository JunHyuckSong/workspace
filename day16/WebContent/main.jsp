<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function newMember(){
		 window.open('new.jsp', '새창으로 회원가입', 'width=400, height=300, menubar=no, status=no, toolbar=no');
	}
</script>
</head>
<body>
	<ul>
		<li>로고</li>
		<li><a href="javascript:newMember()">회원가입</a></li>
		<li><mytag:login/></li>
	</ul>
	
	<hr>
		<form action="board_controller.jsp?action=insertB" method="post">
			<input type="hidden" name="mid" value="${mid}">
			<mytag:write type="board"/>
		</form>
	<hr>
	
	<c:forEach items="${datas}" var="v">
		<c:set var="bvo" value="${v.board}"/>
		${bvo.mid}님의 글:${bvo.msg}[좋아요 : ${bvo.favcnt} | 댓글 : ${bvo.rcnt} <mytag:removeB rmid="${bvo.mid}" bid="${bvo.bid}"/> <br>                         
		<form action="board_controller.jsp?action=insertR&cnt=${cnt}" method="post">
			<input type="hidden" name="mid" value="${mid}">
			<input type="hidden" name="bid" value="${bvo.bid}">
			<mytag:write type="reply"/>
		</form>
		<c:forEach var="vv" items="${v.rdatas}">
			 ${vv.mid}님의 댓글: ${vv.rmsg} <mytag:removeR rmid="${vv.mid}" rid="${vv.rid}"/><br>
		</c:forEach>
		<hr>
	</c:forEach>	
	
	<hr>
	
	
	<!-- "board_controller.jsp?action=fav" -->
	<!-- 이렇게 만들면 cnt파라미터를 보내주지 않았기때문에 null이므로 2로 초기화될 수 있다 -->
	<!-- 참고할 것!! URL로 보내는 속석은 Parameter속성 -->
	
	<a href="controller.jsp?action=main&cnt=${cnt+2}">[더보기]</a>
</body>
</html>