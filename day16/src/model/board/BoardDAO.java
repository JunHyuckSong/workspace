package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BoardDAO { // BoardDAO에서 Borad와 Reply를 동시에 다룬다.
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql_selectAll = "select * from snsboard order by bid desc";//limit 0,?"; "더보기":pagination
	String sql_selectOne = ""; // 현재 프로젝트에서는 상세보기를 지원하지 구현하지 않아도 된다.
	String sql_insert = "insert into snsboard values((select nvl(max(bid),0) from snsboard)+1,?,?,0)";//로그인에 성공한 경우에만 C 진행
	String sql_update = "update snsboard set favcnt=favcnt+1 where bid=?";//좋아요를 +1 시키는 작업
	String sql_delete = "delete from snsboard where bid=? and mid=?";//해당 게시글의 작성자만이 삭제가능!!
	
	String sql_insertR = "insert into reply values((select nvl(max(bid),0) from reply)+1,?,?,?)";
	String sql_deleteR = "delete from reply where rid=? and mid=?";//해당 댓글의 작성자만 삭제
	
	
	// 쌍으로 다니는 정보가 많다 ex)영화+평점 / 상품+후기 / 쇼핑몰+베송회사 etc
	public ArrayList<BoardSet> selectAll(int mcnt) { // int mcnt는 한 페이지에 몇 개의 데이터를 보여주게 할지 정보를 받아옴
		ArrayList<BoardSet> datas = new ArrayList<>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			//pstmt.setInt(1, mcnt);
			System.out.println("mcnt : " + mcnt);
			rs=pstmt.executeQuery();
			while(rs.next()) { // 게시글을 얻는 과정 
				BoardSet bs = new BoardSet();
				BoardVO b = new BoardVO();
				ArrayList<ReplyVO> rdatas = new ArrayList<>();
				
				b.setBid(rs.getInt("bid"));
				b.setFavcnt(rs.getInt("favcnt"));
				b.setMid(rs.getString("mid"));
				b.setMsg(rs.getString("msg"));
				
				String sql="select * from reply where bid=? order by rid desc";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, b.getBid());//rs.getInt("bid")랑 똑같다
				ResultSet rs2 = pstmt.executeQuery();
				int cnt=0; // 댓글의 개수
				while(rs2.next()) { // 해당 게시글에 달린 댓글을 얻는 과정
					ReplyVO r = new ReplyVO();
					r.setBid(rs2.getInt("rid"));
					r.setMid(rs2.getString("mid"));
					r.setRid(rs2.getInt("rid"));
					r.setRmsg(rs2.getString("rmsg"));
					rdatas.add(r);
					cnt++;
				}
				System.out.println(b+"에 댓글의 개수: "+cnt+"개");//rdatas.size()도 가능
				b.setRcnt(cnt); // 게시글의 대한 댓글의 개수
				bs.setBoard(b);
				bs.setRdatas(rdatas);
				datas.add(bs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BoardDAO 중 selectAll에서 예외 발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	
	public boolean insert(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);//insert into snsboard values((select nvl(max(bid),0) from snsboard)+1,?,?,0)
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BoardDAO 중 insert Board에서 예외 발생");
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
			pstmt = conn.prepareStatement(sql_update);//update snsboard set favcnt=favcnt+1 where bid=?
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BoardDAO 중 update에서 예외 발생");
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
			pstmt = conn.prepareStatement(sql_delete);//delete from snsboard where bid=? and mid=?
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BoardDAO 중 delete Board에서 예외 발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean insertR(ReplyVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insertR);
			//insert into reply values((select nvl(max(bid),0) from reply)+1,?,?,?)
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("BoardDAO 중 insert Reply에서 예외 발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public void deleteR(ReplyVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_deleteR);
			//delete from reply where rid=? and mid=?
			pstmt.setInt(1, vo.getRid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}



















