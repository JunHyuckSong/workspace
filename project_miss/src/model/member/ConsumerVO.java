package model.member;

public class ConsumerVO extends MemberVO{
	
	private String nickname;
	private String address;
	private String phoneNumber;
	private String email;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ConsumerVO [member_id=" + getMember_id() + ", member_pw=" + getMember_pw() + ", nickname=" + nickname + ", auth=" + 
				getAuth() + "+address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	
	
}
