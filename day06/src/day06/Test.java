package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		/*
		 * 	1.JDBC 드라이버를 JVM에 로드
		 * 	2.DB에 연결
		 * 	3.DBMS에 데이터를 read,write == SQL문을 수행
		 * 	4.DB연결 해제
		 * 
		 * */
		
		// String 자원들을 상단에 배치하고 conn, stmt같은 변수도 범위(scope)를 넓혀놓음
		String oracleDriver = "oracle.jdbc.driver.OracleDriver"; // 서버프로그램이 바뀌는 경우는 비일비재하므로  이렇게 만들어주는게 편리하다.
		//String mysqlDriver = "con.mysql.driver";	// mysql을 사용하는 경우
		String url = "jdbc:oracle:thin:@localhost:1521:xe";		 // 이렇게 관리해주는 것이 유지보수하기도 쉽다.
		String user = "song";
		String password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		//System.out.print("찾고싶은 번호입력 : ");
		//String num = sc.next();
		System.out.print("찾고싶은 챔피언 : ");
		String charname = sc.next();
		//String sql = "select * from test where a=" + num;
		String sql = "select * from TEST where b like '%" + charname + "%'";
		
		try {
			//1.JDBC 드라이버를 JVM에 로드
			Class.forName(oracleDriver);
			System.out.println("JDBC 드라이버 로드 성공!");
			
			//2.DB에 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클에 연결 성공!");
			
			//3.DBMS에 데이터를 read,write == SQL문을 수행
			stmt = conn.createStatement();// 데이터베이스로 보낼 sql구문(statement)를 저장할 변수 stmt.
			ResultSet rs = stmt.executeQuery(sql);// iterator과 유사한 rs
			// Update, Delete, Insert의 경우에는 stmt.executeUpdate(sql)을 사용
			int cnt = 0; // rs는 null이 아니므로 res==null로 조건을 세우면 안된다.
			while (rs.next()) {
				System.out.println(rs.getInt("a")+"  :  " + rs.getString("b"));// getXxxx의 인자는 컬럼명을 써주면 된다. Xxxx는 컬럼의 데이터타입과 동일해야한다.(ex.int,varchar등등)
				cnt++;
			}
			if(cnt == 0) {
				System.out.println("없는 데이터입니다!");
			}
			rs.close(); // 생략하는 경우도 있지만 더 안정적인 구성을 위해 rs도 close해준다. --> stmt를 close하면 자동으로 rs도 close되기 때문.
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
			//4.DB연결 해제
			try {
				conn.close(); // 예외가 발생하더라도 finally에서 확실히 연결을 해제시켜주는 것이 안전하다. 
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
