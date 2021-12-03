<%@page import="board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	request.setCharacterEncoding("UTF-8");
%> --%>
<jsp:useBean id="dao" class="board.BoardDAO"/>
<jsp:useBean id="vo" class="board.BoardVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	//사용자가 어떤 요청을 했는지에 따라
	//비즈니스메서드를 수행시켜야함(DAO를 호출해야함)
	
	String action = request.getParameter("action");

	if(action.equals("main")){
		ArrayList<BoardVO> datas = dao.selectAll();
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
	}else if(action.equals("board")){
		BoardVO data = dao.selectOne(vo);
		request.setAttribute("data", data);
		pageContext.forward("board.jsp");
	}else if(action.equals("insert")){
		//System.out.print(vo);
		if(dao.insert(vo)){
			response.sendRedirect("controller.jsp?action=main");
		}else{
			throw new Exception("insert수행 중 오류발생");
		}
		//throw new Exception("insert수행 중 오류발생");
	}else if(action.equals("update")){
		if(dao.update(vo)){
			response.sendRedirect("controller.jsp?action=main");
		}else{
			throw new Exception("update수행 중 오류발생");
		}
	}else if(action.equals("delete")){
		if(dao.delete(vo)){
			response.sendRedirect("controller.jsp?action=main");
		}else{
			throw new Exception("delete수행 중 오류발생");
		}
	}else{
		out.println("<script>alert('action파라미터의 값을 확인해주세요.')</script>");
	}

%>
