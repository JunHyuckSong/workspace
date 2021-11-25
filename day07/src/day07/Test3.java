package day07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql_select = "";
		
		try {
			//JDBC를 JVM에 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//DB에 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "song", "1234");
			
			//sql에 구문을 통해 CRUD작업 수행		
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql_select); // select 하는 경우
			//int resultCnt = stmt.executeUpdate(sql); 
			
			
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 연결 해제
				conn.close();
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
