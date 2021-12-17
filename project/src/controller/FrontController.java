package controller;

import java.io.IOException;
import java.text.Normalizer.Form;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
//사용자의 모든 요청을 FC(FrontController)로 향하게 해야함!!  --> FC는 병원으로 치면 접수처랑 비슷하다.
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}
	
	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청을 파악
		String uri = request.getRequestURI();
		System.out.println(uri); // /project/controller.do
		String cp = request.getContextPath();
		System.out.println(cp); // /project
		StringBuffer url = request.getRequestURL();
		System.out.println(url);// http://localhost:8085/project/controller.do
		
		String command = uri.substring(cp.length()); // /controller.do
		System.out.println(command);
		
		ActionForward forward = null;  // forward는 우리가 새로만들어낸 자료형이다!!
		//2. 각요청에 대한 Controller 처리를 수행
		if(command.equals("/main.do")) { //controller.jsp?action=main을 이제부턴 이렇게 대체한다!!
			System.out.println("main화면 보여줘야함");
			try {
				forward = new MainAction().execute(request, response);
				//1. 데이터 전송여부 == 데이터 전달방식 (sendRedirect를 할 것인가 forward를 할 것인가)
				//2. 향하는 페이지 정보
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//데이터 전송여부(boolean) + 향하는  페이지 정보(String) = new MainAction().execute();
			// ---> class 선언이 필요(ActionForward)
		
				//BoardDAO 호출
				//AL만들어서 정보 저장
				//request.setA(AL)
			
		}
		else if(command.equals("/board.do")) {
			try {
				forward = new BoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				//BoardDAO 호출
				//BoardVO 호출
				//request.setA(vo)
		}
		else if(command.equals("/insert.do")) {
			System.out.println("insert화면 보여줘야함");
			try {
				forward = new InsertAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if(command.equals("/update.do")) {
			System.out.println("update완료 보여줘야함");
			try {
				forward = new UpdateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete.do")) {
			System.out.println("delete완료 보여줘야함");
			try {
				forward = new DeleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("잘못된 url");
			System.out.println(uri);
		}
		
		
		if(forward!=null) {//예외가 발생해서 null일 수 도 있으니까 분기점이 필요 =>NullPointerException 방지
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				//pageContext.forward();
				//전달해야할 정보가 존재함을 의미한다.
				//[RequestDispatcher API를 사용]
				//  : 요청 재지정 기능을 구현해주는 API
				//  : 클라이언트로부터 요청받은 사항을 직접 응답하지 않고
				//    다른 자원이 넘겨받아 처리 결과를 대신 응답하는 것. == 클라이언트의 요청에 대하여 서버의 다른 자원들로 그 요청을 처리하도록 재지정하는 것
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
			
			
			
			
		}
		
		
	}
	
	
	
}





