<%@page import="model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<jsp:useBean id="dao" class="model.BoardDAO"/>
<jsp:useBean id="vo" class="model.BoardVO"/>
<jsp:setProperty property="*" name="vo"/>
<% // controller도 내용적인 측면이 아니므로 HTML요소가 필요가 없다
	//controller의 목적은 main페이지를 보여주기 위함이다.
	//1.index가 controller에게 main페이지요청
	//2.controller는 main페이지 데이터를 찾아와야함
	//	--> Model에게 데이터 가져와 요청
	//		DB 연동하여 데이터 가져옴
	//3.C main페이지가 완성됬으니까 가져가서 보여줘
	//4.View가 main페이지를 사용자에게 보여준다.
	
	String action = request.getParameter("action");
	
	if(action.equals("main")){
		//메인페이지 보여줘
		//1.M에게서 데이터를 확보
		//BoardDAO dao = new BoardDAO(); --> useBean을 통해 수행
		ArrayList<BoardVO> datas = dao.selectAll();
		//2.V한테 데이터를 전달
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");	
	
	}else if(action.equals("board")){
		//상세페이지 보여줘 --> selecto_one
		//1.M에게서 데이터를 확보
		//System.out.println(vo); --> bid = 1 만 찍힌다. 나머지는 다 null값, 이유인 즉슨 main에서 넘어올 때 bid값만 넘어왔으므로!! --> 이해안되면 수업영상 다시확인 day09
		BoardVO data = dao.selectOne(vo);
		request.setAttribute("data", data);
		//2.V한테 데이터를 전달
		pageContext.forward("board.jsp");
	}else if(action.equals("update")){
		if(dao.update(vo)){
			response.sendRedirect("controller.jsp?action=main");
		}
		throw new Exception("update 수행 중 오류 발생");
	}else if(action.equals("insert")){
		//System.out.println(vo); --> writer, content, title의 값이 넘어온다, 이유인 즉슨 form에서 넘어올 때 w,c,t가 넘어오니까!! --> 이해안되면 수업영상 다시확인 day09
		if(dao.insert(vo)){ // 추가가 잘 됐으면
			response.sendRedirect("controller.jsp?action=main");
			// C(insert) -> C(main) -> V(main)  : 버튼누르는 액션
		}
		throw new Exception("insert 수행 중 오류 발생");
	}else if(action.equals("delete")){
		if(dao.delete(vo)){ // 삭제가 잘 됐으면
			response.sendRedirect("controller.jsp?action=main");
			// C(insert) -> C(main) -> V(main)  : 버튼누르는 액션
		}
		throw new Exception("delete 수행 중 오류 발생");
	}
	else{
		out.println("<script>alert('action파라미터의 값이 올바르지 않습니다.')</script>");
	}
	
%>




