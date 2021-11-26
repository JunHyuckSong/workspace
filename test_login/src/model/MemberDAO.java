package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql_selectOne = "select * from login where id=? and password=?";
	
	public boolean check(MemberVO vo) {
		conn = JDBCUtil.connect();
		boolean isMember= true;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getPassword());
			ResultSet rs =  pstmt.executeQuery();
			if(!rs.next()) {
				isMember = false;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isMember;
	}
	
}
