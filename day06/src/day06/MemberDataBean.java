package day06;

import java.util.ArrayList;

public class MemberDataBean {
	ArrayList<MemberBean> datas = new ArrayList<>();

	public ArrayList<MemberBean> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<MemberBean> datas) {
		this.datas = datas;
	}
	
	public void add(MemberBean mb) {
		datas.add(mb);
	}
	
	
	// 검색 로직 --> 이름을 입력해서 멤버정보를 얻기
	public MemberBean search(String sname) {
		for (MemberBean v : datas) {
			if(v.getUname().equals(sname)) {
				return v;
			}
		}
		return null;
	}
}
