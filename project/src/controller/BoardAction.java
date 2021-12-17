package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//DAO,VO,setVO
		BoardVO vo = new BoardVO(); //controller.jsp 7번 라인
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		BoardDAO dao = new BoardDAO(); //controller.jsp 6번 라인
		BoardVO data = dao.selectOne(vo);
		request.setAttribute("data", data);
		
		ActionForward forward = new ActionForward();
		forward.setPath("board.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
