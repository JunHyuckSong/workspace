<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${mid==null }">
	<input type="text" name="rmsg" disabled="disabled" value="로그인 후 글 댓글등록이 가능합니다">
</c:if>
<c:if test="${mid!=null }">
	<input type="text" name="rmsg" placeholder="댓글 내용 작성" size="50" required>
	<input type="submit" value="글 등록">
</c:if>
