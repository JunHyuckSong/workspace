package controller;

public class ActionForward {
	private boolean redirect; // 방식(데이터 전송여부)
	private String path; // 페이지 경로
	
	//boolean redirect 값에 대한 차이
	//- redirect방식 T == 전달할 정보가 없음
	//- forward 방식 F == 전달할 정보가 있음
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
