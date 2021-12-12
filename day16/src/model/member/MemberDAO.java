package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql_insert = "insert into member values(?,?,?)";
	String sql_selectOne = "select * from member where mid = ?";
	
	
	public boolean insert(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("MemberDAO에서 insert중 예외발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean selectOne(MemberVO vo) {
		//로그인 성공여부를 반환하는 메서드
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("해당하는 id 존재");
				//이제 비밀번호가 일치하는지 여부를 파악해야함
				if(rs.getString("mpw").equals(vo.getMpw())) {
					System.out.println("비밀번호 일치");
					return true;
				}else {
					System.out.println("비밀번호 불일치");
					return false;
				}
				
			}
			System.out.println("해당아이디 존재X");
			rs.close();
		} catch (SQLException e) {
			System.out.println("MemberDAO에서 selectOne중 예외발생");
			e.printStackTrace();
			return false;
			
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return false;
	}
	
	
	
	
	
	
	
}
