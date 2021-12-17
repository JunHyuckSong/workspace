package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardSet;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		String cnt = request.getParameter("cnt");
		int mcnt = 2;
		if(cnt!=null) {
			mcnt = Integer.parseInt(cnt);
		}
		ArrayList<BoardSet> datas = dao.selectAll(mcnt);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", mcnt);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
