package model;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDI {
	
	
	
	public static Connection getConnetion() {
		Connection conn = null;
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env"); 
			DataSource ds = (DataSource)envContext.lookup("jdbc/orcl");
			conn = ds.getConnection();
		} 
		catch (Exception e) {
			System.out.println("JNDI 클래스에서 예외발생");
			e.printStackTrace();
		}
		
		return conn;
	}
}
