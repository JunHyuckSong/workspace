package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class NewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMname(request.getParameter("mname"));
		vo.setMpw(request.getParameter("mpw"));
		
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
		if(dao.insert(vo)) {
			out.println("<script>alert('가입에 성공하셨습니다.');window.close();</script>");
		}else {
			out.println("<script>alert('회원가입실패');history.go(-1);</script>");
		}
		
		return null;
	}

}
