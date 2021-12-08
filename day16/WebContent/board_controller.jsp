<%@page import="model.board.BoardSet" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="model.board.BoardDAO"/>
<jsp:useBean id="vo" class="model.board.BoardVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	String action = request.getParameter("action");
	//최초에는 2개의 게시글을 볼 수 있음. URL 파라미터에 현재게시글을 몇개까지 열람할 수 있는지에 대한 정보를 저장해야함.
	String cnt = request.getParameter("cnt"); // mcnt값이 null이라면 바로 형변환이 안되며 NullpointExcetption이 발생
	int mcnt = 2;
	if(cnt!=null){
		mcnt = Integer.parseInt(cnt);
	}

	if(action.equals("main")){
		ArrayList<BoardSet> datas = dao.selectAll(mcnt);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", mcnt);
		pageContext.forward("main.jsp"); // 게시글1개+댓글N개
	}else if(action.equals("fav")){
		System.out.println(vo);//vo 확인용
		if(dao.update(vo)){
			pageContext.forward("board_controller.jsp?action=main"); // 현재페이지 유지하기 위해 forward
		}else{
			System.out.println("controller중 fav(좋아요) 증가 Action 에러");
		}
	}
%>