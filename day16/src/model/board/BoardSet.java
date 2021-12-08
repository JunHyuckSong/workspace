package model.board;

import java.util.ArrayList;

public class BoardSet {
	//BoardVO 1개에
	//RelpyVO n개가 함께 붙어있는 헝태의 '게시글'데이터를 표현하는 클래스
	private BoardVO board;
	private ArrayList<ReplyVO> rdatas = new ArrayList<>();
	public BoardVO getBoard() {
		return board;
	}
	public void setBoard(BoardVO board) {
		this.board = board;
	}
	public ArrayList<ReplyVO> getRdatas() {
		return rdatas;
	}
	public void setRdatas(ArrayList<ReplyVO> rdatas) {
		this.rdatas = rdatas;
	}
	@Override
	public String toString() {
		return "BoardSet [board=" + board + ", rdatas=" + rdatas + "]";
	}
	
	
}
