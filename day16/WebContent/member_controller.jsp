<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="mdao" class="model.member.MemberDAO"/>
<jsp:useBean id="mvo" class="model.member.MemberVO"/>
<jsp:setProperty property="*" name="mvo"/>
<%
	String action = request.getParameter("action");
	

	if(action.equals("new")){
		//MemberDAO를 통해 insert()를 수행 -> 회원가입
		//화면에 회원가입 성공여부 출력
		if(mdao.insert(mvo)){
			out.println("<script>alert('가입에 성공하셨습니다.');window.close();</script>");
		}else{
			out.println("<script>alert('회원가입실패');history.go(-1);</script>");
		}
	}else if(action.equals("login")){
		//컨트롤러에서 mdao로 login()(==R selectOne)
		//	->컨트롤러가 만들어내는 데이터 => mid
		
		//${mid}를 결과로 줘야됨. --> session.setAtrribute()
		System.out.println(mvo); // mvo객체의 mid와 mpw값은 있지만 mname은 null값을 가짐 -- 로깅용
		if(mdao.selectOne(mvo)){
			session.setAttribute("mid", mvo.getMid());
			//out.println("<script>alert('로그인성공.');</script>");
			response.sendRedirect("board_controller.jsp?action=main");
		}else{//로그인 실패
			out.println("<script>alert('로그인실패.');history.go(-1);</script>");
			//sendredirect로 다른 방식 가능
		}
		
	}
	else if(action.equals("logout")){
		session.removeAttribute("mid"); //세션에 저장된 값을 제거
		response.sendRedirect("board_controller.jsp?action=main");
	}
	
	
	
%>