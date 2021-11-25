package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	// 1.DBMS와의 연동(JDBC)  --> DBMS와 연동의 경우, 다른 DAO도 사용한다. 매번 모든 DAO에 들어갈 이유가 없는 공통로직이다. 
	//	  				   --> 따로 크게 구현하자 JDBCUtil.java를 가져와서 사용
	// 2.비즈니스 메서드(CRUD)  --> 각각의 DAO마다 사용하는 로직
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql_selectAll = "select * from projboard order by bid desc";
	String sql_selectOne = "select * from projboard where bid = ?"; 
	
	// 보통 5가지 비즈니스 메서드 구현!!
	public ArrayList<BoardVO> selectAll(){
		//JDBCUtil.connect(); 아직 구현은 안함 , 연결되었다고 가정
		ArrayList<BoardVO> datas = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBid(rs.getInt("bid"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				datas.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public BoardVO selectOne(int bid){
		// 이곳 구현하기
		BoardVO vo = new BoardVO();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setBid(rs.getInt("bid"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//JDBCUtil.disconnect(pstmt, conn);
		}
		return vo;
	}
	
	public boolean insert() {
		
	}
	
	public boolean update() {
		
	}

	public boolean delete() {
	
	}
}
