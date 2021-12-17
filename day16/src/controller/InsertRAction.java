package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.ReplyVO;

public class InsertRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		BoardDAO dao = new BoardDAO();
		ReplyVO rvo = new ReplyVO();
		rvo.setBid(Integer.parseInt(request.getParameter("bid")));
		rvo.setMid(request.getParameter("mid"));
		rvo.setRmsg(request.getParameter("rmsg"));
		dao.insertR(rvo);
		
		String cnt = request.getParameter("cnt");
		int mcnt = 2;
		if(cnt!=null) {
			mcnt = Integer.parseInt(cnt);
		}
		request.setAttribute("cnt", mcnt);
		
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
