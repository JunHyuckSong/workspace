package calculator;

import java.io.IOException;
import java.util.Iterator;

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
@WebServlet("/Calc")
public class Calc extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession sesseion = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) // 사용자가 숫자를 입력했다다면!
			v = Integer.parseInt(v_); // 입력한 숫자(문자형)를 정수형으로 형변환해준다.
		
		if(op.equals("=")){
			int result = 0;
			
			/*
			// application을 이용한 상태 값 저장------------------------------------------------
			int x = (Integer)application.getAttribute("value");// 이전에 사용자가 전달한 숫자값
			String prevOp = (String) application.getAttribute("op"); // 이전에 사용자가 전달한 연산자
			*/		
			
			// session을 이용한 상태 값 저장 ----------------------------------------------------
			/*int x = (Integer)sesseion.getAttribute("value");// 이전에 사용자가 전달한 숫자값
			String prevOp = (String)sesseion.getAttribute("op"); // 이전에 사용자가 전달한 연산자
			*/
			// cookie를 이용한 상태 값 저장-----------------------------------------------------
			int x = 0;
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("value")) {
					x = Integer.parseInt(cookie.getValue());
					break;
				}
			}
			String prevOp = "";
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("op")) {
					prevOp = cookie.getValue();
				}
			} // 쿠기name을 찾아야하는 번거로움이 있다.
			
			int y = v; // 지금 사용자가 전달한 값
			if (prevOp.equals("+")) {
				result = x + y;
			}else {
				result = x - y;
			}
			
			response.getWriter().println("result is " + result);
		
		}else {
			/*// application을 이용한 상태 값 저장------------------------------------------------
			application.setAttribute("value", v);
			application.setAttribute("op", op);*/
			
			/*// session을 이용한 상태 값 저장----------------------------------------------------
			sesseion.setAttribute("value", v);
			sesseion.setAttribute("op", op);
			sesseion.setMaxInactiveInterval(30);*/
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			//valueCookie.setPath("/Calc"); // 나중에 쿠키를 받을 수 있는 웹서버를 지정할 수 있다. 
			//opCookie.setPath("/Calc");
			//valueCookie.setMaxAge(60*60); // 쿠키의 만료기간을 정할 수 있다. 60*60은 60분이라는 뜻
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc.html");
		}
		
		
		
	}

}














