package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection connect() {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="song";
		String password="1234";
		
		Connection conn = null;
		// 이 곳 구현하기
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	//1. 코드의 재사용성 증가
	//2. 유지보수 용이
	//3. 협업 용이

	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		// TODO Auto-generated method stub
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
