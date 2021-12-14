package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.JNDI;

public class Bank1 {
	private int bid;
	private String name;
	private int balance;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Bank1 [bid=" + bid + ", name=" + name + ", balance=" + balance + "]";
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public boolean transfer(int balance) {
		// bank1->bank2로 계좌이체하는 로직
		
		conn = JNDI.getConnection();
		
		try {
			conn.setAutoCommit(false);// 1) 오토commit을 해제하는 과정
			
			//*********************이 과정은 하나의 작업 단위이다*********************
			pstmt = conn.prepareStatement("update bank1 set balace = balance-? where bid=11");
			pstmt.setInt(1, balance);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update bank2 set balace = balance+? where bid=21");
			pstmt.setInt(1, balance);
			pstmt.executeUpdate();
			//*********************이 과정은 하나의 작업 단위이다*********************
			
			pstmt = conn.prepareStatement("select * from bank1 where bid=11"); // 잔액을 조회하는 코드
			ResultSet rs = pstmt.executeQuery();
					
			rs.next(); // rs는 iterator과 같으므로 rs.next()를 한 번 해줘야 데이터에 접근이 가능하다!!
			
			if(rs.getInt("balance")<0) { // 송금할 금액이 0보다 작다면?
				conn.rollback();
				return false;
			}
			conn.commit();
			
			conn.setAutoCommit(true); // 4)오토commit 원상복구 , 이부부은 사실 굳이 작성하지 않아도 자동 복구가 된다.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
		return true;
	}
	
	public void select() {
		conn = JNDI.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from bank1");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			bid = rs.getInt("bid");
			name = rs.getString("name");
			balance = rs.getInt("balance");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}





