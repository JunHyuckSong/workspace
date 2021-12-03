package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {	
	
	public static Connection connect(){		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="song";
		String password="1234";
		Connection conn = null;
		try {
			//JDBC-JVM 
			Class.forName(driver);
			//DB연결
			conn = DriverManager.getConnection(url, user, password);
			
			
		} catch (Exception e) {
			System.out.println("DB연결 실패");
			
		}
		return conn;
	}
		
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("DB연결해제 실패");
			
		}
		
	}
	
}
