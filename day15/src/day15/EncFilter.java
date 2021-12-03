package day15;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
@WebFilter("*.jsp")
public class EncFilter implements Filter {
	
	private String encoding;
	
    /**
     * Default constructor. 
     */
    public EncFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//--------------탈취한 request, respose를 사용하는 파트-----------------
		request.setCharacterEncoding(encoding);
		System.out.println("필터 doFilter()메서드 수행함");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//init() : 필터 최초 생성시 1회 동작하는 메서드
		this.encoding = fConfig.getServletContext().getInitParameter("encoding"); // .xml 설정을 갖춰야 한다!!
	}

}
