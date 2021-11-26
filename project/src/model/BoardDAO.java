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
	String sql_insert = "insert into projboard values((select nvl(max(bid),0)+1 from projboard),?,?,?)";
	String sql_delete = "delete from projboard where bid = ?";
	String sql_update = "update projboard set title = ?, writer = ?, content = ? where bid = ?";
	
	// 보통 5가지 비즈니스 메서드 구현!!
	public ArrayList<BoardVO> selectAll(){
		//JDBCUtil.connect(); 아직 구현은 안함 , 연결되었다고 가정
		conn = JDBCUtil.connect();
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
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
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public BoardVO selectOne(BoardVO vo){ // 이와 같은 코드는JSP식 코드(int bid)이다.. / JSP식 코드 -> Spring식 코드(BoardVO vo)로 바꾸는 시도가 필요하다.
		// 인자를 int타입으로 고정 -> 유지보수 불리
		// title, content, writer,... -> VO를 인자로 설정
		conn = JDBCUtil.connect();
		BoardVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getBid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { // while을 써도 상관없지만 한개의 rs만 가져오므로 if를 쓰는 것이 더 좋다.
				data = new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean update(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	public boolean delete(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
