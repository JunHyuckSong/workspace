package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class MemberDAO {
	// CRUD 비즈니스 메서드 구현
	// 1. 회원가입에 필요한 C - insert
	// 2. 로그인에 필요한 R - selectOne
	// 3. 회원정보 수정에 필요한 U - update
	// 4. 회원탈퇴도 구현할 수 있지만 아직 설계하지 않았으므로..
	
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	String sql_selectOne = "select * from member where member_id = ?";
	
	public void selectOne(MemberVO mvo) { // mvo객체를 통해 member_id와 member_pw를 넘겨받아야 한다.
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne); //select * from member where member_id = ? 한 개의 rows 리턴
			pstmt.setString(1, mvo.getMember_id());
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
