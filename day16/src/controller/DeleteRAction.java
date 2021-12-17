package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.ReplyVO;

public class DeleteRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		ReplyVO rvo = new ReplyVO();
		rvo.setRid(Integer.parseInt(request.getParameter("fid")));
		dao.deleteR(rvo);
		
		String cnt = request.getParameter("cnt");
		int mcnt = 2;
		if(cnt!=null) {
			mcnt = Integer.parseInt(cnt);
		}
		request.setAttribute("cnt", mcnt);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
