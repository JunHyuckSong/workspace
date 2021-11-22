package calculator;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/CalcPage")
public class CalcPage extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String exp = "0"; // cookies가 null인 경우 exp는 "0"값을 가진다.
		if(cookies != null) {// cookies가 null이 아닌 경우 cookie중 이름이 "exp"인 값의 value를 exp에 저장
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("exp")) {
					exp = cookie.getValue();
				}
			}
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// --------------------------------------------------------------
		// |서블릿으로 페이지를 출력하려면 이렇게 번거로운 작업이 필요하다... --> JSP의 필요성!!!|
		// --------------------------------------------------------------
		out.write("<!DOCTYPE html>"); // out.println()을 써도 상관없다.
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style type=\"text/css\">");
		out.write("	input {");
		out.write("		width: 50px;");
		out.write("		height: 50px;");
		out.write("	}");
		out.write("	.output{");
		out.write("		height: 50px;");
		out.write("		background: #e9e9e9;");
		out.write("		font-size: 24px;");
		out.write("		font-weight: bold;");
		out.write("		text-align: right;");
		out.write("		padding: 0px 5px;");
		out.write("	} ");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"Calc2\" method=\"post\">");
		out.write("		<table>");
		out.write("			<tr>");
		out.printf("				<td colspan=\"4\" class=\"output\">%s</td>",exp);
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("				<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
		
		
	}

}














