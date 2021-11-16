package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalcServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2, res;
		String op;
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("op");
		res = calc(num1,num2,op);
		
		response.setContentType("text/html; charset=UTF-8");
	      
	    PrintWriter out=response.getWriter();
	    out.println("<HTML>");
	    out.println("<BODY>");
	    out.println("<h1>"+num1 + op + num2+ "</h1>");
	    out.println("<h1>계산 결과는 " + res + "입니다.</h1>");
	    out.println("</BODY>");
	    out.println("</HTML>");

	}

	public int calc(int num1, int num2, String op) {
		int res;
		if(op.equals('+')) {
			res = num1 + num2;
		}
		else {
			res = num1 - num2;
		}
		
		return res;
	}

	

}
