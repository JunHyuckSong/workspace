package day07;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingTest {
	
	public static void main(String[] args) {
		String url = "https://comic.naver.com/webtoon/weekday";
		String[] days = {"mon","tue","wed","thu","fri","sat","sun"}; // 요일별로 확인하기 위해 String배열로 요일 선언
		
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
	    String user="song";
	    String password="1234";
	    Connection conn = null;
		Statement stmt = null;
		String selectQuery = "select * from WEBTOON";
	    
		try {
			//JDBC - JVM 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DB연결
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			stmt = conn.createStatement(); // Statement 만들 준비
			ResultSet rs =  stmt.executeQuery(selectQuery); // 이터레이터와 비슷한 ResultSet
			while(rs.next()) {
				System.out.println(rs.getString("day")+" : "+rs.getString("webtoon_name"));
			}
			
			//===================================네이이버에서 크롤링하는 부분============================================
			// url을 통해 doucument 형태로 데이터를 크롤링해옴.
			/*Document doc = Jsoup.connect(url).get();
			for (String day : days) {	// 요일별로 웹툰제목 데이터 추출하기	
				Elements ele = doc.select("."+ day + "+ ul"); // 요일별 웹툰을 구별하기 cssQuery .day+ul (인접 형태 선택자)
				Iterator<Element> itr= ele.select("li > a").iterator(); // 웹툰제목이 text로 있는 a태그들을 이터레이터로 변환
				
				while (itr.hasNext()) {
					//System.out.println(itr.next().text()); // 웹툰 이름이 출력된다.
					String webtoon = itr.next().text();
					int n = stmt.executeUpdate("insert into WEBTOON values('"+day+"','"+webtoon+"')"); // DB에 크롤링한 데이터 insert구문을 통해 저장
				}
				System.out.println("--------------------------"); // 요일마다 구분하기 위해 임시로 점선 표시 
			}*/
			//==================================================================================================
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//DB 연결 해제
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
