package calculator;

import java.io.IOException;
import java.util.Iterator;

import javax.script.ScriptEngine;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp = ""; // cookies가 null값일 때 exp는 ""로 초기화
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("exp")) {
					exp = cookie.getValue();
				}
			}
		}
		
		if(operator != null && operator.equals("=")) {
			// 이 부분을 구현해야 함
			
			
			
		}else {			
			// 밑 3개 중 cookie가 넘어올 떈 하나씩박에 넘어오지 않으므로 3개중 한개만 실행됨.
			exp += (value == null)?"":value; // 1
			exp += (operator == null)?"":operator; // 2
			exp += (dot == null)?"":dot; // 3
		}
		
		
		Cookie expCookie = new Cookie("exp", exp);
		
		response.addCookie(expCookie);
		response.sendRedirect("CalcPage");
		
						
	}

}














