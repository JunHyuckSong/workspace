package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class InsertBAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMsg(request.getParameter("msg"));
		dao.insertB(vo);
		
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}
