package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("isLogout", true);
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
