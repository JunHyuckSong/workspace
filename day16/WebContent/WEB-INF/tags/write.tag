<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="type"%>


<c:if test="${mid==null }">
	<c:choose>
		<c:when test="${type=='board'}">
			&nbsp;<input type="text" name="msg" disabled="disabled" value="로그인 후 글 등록이 가능합니다">	
		</c:when>
		<c:when test="${type=='reply'}">
			&nbsp;<input type="text" name="rmsg" disabled="disabled" value="로그인 후 댓글 등록이 가능합니다">
		</c:when>
	</c:choose>
</c:if>
<c:if test="${mid!=null }">
	<c:choose>
		<c:when test="${type=='board'}">
			&nbsp;<input type="text" name="msg" placeholder="글 내용 작성" size="50" required>
			<input type="submit" value="글 등록">
		</c:when>
		<c:when test="${type=='reply'}">
			&nbsp;<input type="text" name="rmsg" placeholder="댓글 내용 작성" size="50" required>
			<input type="submit" value="댓글 등록">
		</c:when>
	</c:choose>
</c:if>
