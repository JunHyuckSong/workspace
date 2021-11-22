package calculator;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(operator != null && operator.equals("C")) {
			// 쿠키를 지우는 부분
			exp = "";// 쿠키를 초기화하는 것은 맞지만 완벽한 초기화는 아님
			
						
		}else {			
			// 밑 3개 중 cookie가 넘어올 떈 하나씩박에 넘어오지 않으므로 3개중 한개만 실행됨.
			exp += (value == null)?"":value; // 1
			exp += (operator == null)?"":operator; // 2
			exp += (dot == null)?"":dot; // 3
		}
		
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C")) { // 이 부분을 통해 완벽히 쿠키를 지울 수 있음.
			expCookie.setMaxAge(0);
		}
		response.addCookie(expCookie);
		response.sendRedirect("CalcPage");
		
						
	}

}














