package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	//CRUD 비즈니스 메서드를 만드는 곳.
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql_selectAll = "select * from testboard order by id desc";
	String sql_selectOne = "select * from testboard where id=?";
	String sql_insert = "insert into testboard values((select nvl(max(id),0)+1 from testboard),?,?,?)";
	String sql_update= "update testboard set username=?, title=?, content=? where id=?";
	String sql_delete = "delete from testboard where id=?";
	
	public ArrayList<BoardVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<BoardVO> datas = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getInt("id"));
				vo.setUsername(rs.getString("username"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				datas.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public BoardVO selectOne(BoardVO vo) {
		conn = JDBCUtil.connect();
		BoardVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {		
				data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setUsername(rs.getString("username"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(BoardVO vo) {
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_insert);//"insert into testboard values(select nvl(max(id),0)+1 from testboard,?,?,?)";
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DAO에서 insert중 오류");
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean update(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);//"update testboard  username=?, title=?, content=? where id=?";
			
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DAO에서 update중 오류");
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
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DAO에서 delete중 오류");
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	
}














