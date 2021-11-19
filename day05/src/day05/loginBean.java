package day05;

public class loginBean {
	
	private String uid;
	private String upw;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}
	// DB데이터를 대체하는 데이터	
	final String did = "admin";
	final String dpw = "1234";
	
	public boolean check() {
		if(uid.equals(did) && upw.equals(dpw)) {
			return true;
		}
		return false;
	}
	
	
	
}
