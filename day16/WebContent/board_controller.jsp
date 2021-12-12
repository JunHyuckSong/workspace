<%@page import="model.board.BoardSet" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="model.board.BoardDAO"/>
<jsp:useBean id="vo" class="model.board.BoardVO"/>
<jsp:setProperty property="*" name="vo"/>
<jsp:useBean id="rvo" class="model.board.ReplyVO"/>
<jsp:setProperty property="*" name="rvo"/>
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
	}else if(action.equals("deleteB")){
		if(dao.deleteB(vo)){
			System.out.println(vo);
			response.sendRedirect("board_controller.jsp?action=main"); // 유지할 내용이 없기 때문에 sendredirect
			// CUD의 경우 sendRedirect()를 많이 쓰고 R의 경우 forward()를 많이 쓴다.
		}else{
			System.out.println("deleteB 중 에러");
		}
	}else if(action.equals("deleteR")){
		if(dao.deleteR(rvo)){
			System.out.println(vo);
			pageContext.forward("board_controller.jsp?action=main"); // 댓글을 작성할 경우 화면 유지하는 것이 좋다.
		}else{
			System.out.println("deleteR 중 에러");
		}
	}else if(action.equals("insertB")){ //mid, msg => View 작업자는 C에게 이 2개의 값을 전달해야함.
		if(dao.insertB(vo)){
			System.out.println(vo);
			response.sendRedirect("board_controller.jsp?action=main");
		}else{
			System.out.println("insertB 중 에러");
		}
	}else if(action.equals("insertR")){ // cnt, bid, mid, rmsg => View 작업자는 C에게 이 4개의 값을 전달해야함.
		if(dao.insertR(rvo)){
			System.out.println(rvo);
			pageContext.forward("board_controller.jsp?action=main");
		}else{
			System.out.println("insertR 중 중 에러");
		}
	}
	
	
	
	
%>