package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//인코딩(UTF-8)
		// 필터에서 처리가능
		
		//DAO,VO,setVO --> 불필요하면 작성할 필요없음
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardVO> datas = dao.selectAll(); // M과의 연동(비즈니스메서드를 수행)
		request.setAttribute("datas", datas);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp"); //경로
		forward.setRedirect(false);	 //방식  - 전달할 정보 있음
		
		return forward;
	}

}
