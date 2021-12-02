package day13;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//리스너
//외부에서 동작을 감지(모니터링)하여 특정 메서드를 수행하는 대상
@WebListener
public class InitialMember implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) { // 서버의 중지
		
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) { //서버의 동작 , 초기데이터 세팅할 때 유용.
		ArrayList<Member> datas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Member data = new Member("Lulu"+(i+1),"010-1234-123"+i);
			datas.add(data);
		}
		datas.add(new Member("Ahri",null));
		datas.add(new Member("Echo",null));
		ServletContext context = sce.getServletContext();
		 // context는 서버 scope(application scope)
		context.setAttribute("datas",datas);
		context.setAttribute("data",new Member());
	}
}
