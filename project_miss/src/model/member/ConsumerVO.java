package model.member;

public class ConsumerVO{
	private String member_id;
	private String nickname;
	private String address;
	private int postcode;
	private String better_address;
	private String reference;
	private String phoneNumber;
	private String email;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
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
	
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getBetter_address() {
		return better_address;
	}
	public void setBetter_address(String better_address) {
		this.better_address = better_address;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "ConsumerVO [member_id=" + member_id + ", nickname=" + nickname + ", address=" + address + ", postcode="
				+ postcode + ", better_address=" + better_address + ", reference=" + reference + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
	
	
}
