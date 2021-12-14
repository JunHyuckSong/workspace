package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;



public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql_insert = "insert into member values(?,?,?)";
	String sql_select = "select * from member"; // 언제든지 selectAll검색결과군 필터조건이 올 수도 있으므로 ex)where절
	
	public boolean insert(MemberVO mvo) {
		conn = JNDI.getConnetion();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, mvo.getMid());
			pstmt.setString(2, mvo.getMpw());
			pstmt.setString(3, mvo.getMname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDAO insert()에서 문제발생");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
		
	
	public ArrayList<MemberVO> select(MemberVO mvo) {
		conn = JNDI.getConnetion();
		ArrayList<MemberVO> datas = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql_select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				datas.add(data);
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO select()에서 문제발생");
			e.printStackTrace();
		}
		return datas;
	}
	
	
}
















