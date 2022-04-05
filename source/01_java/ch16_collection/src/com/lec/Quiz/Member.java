package com.lec.Quiz;

public class Member {
	private String name;
	private String tel;
	private String address;

	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		if (name.equals(null)) {
			return "가입된 회원이 하나도 없습니다.";
		}
		return String.format("%s\t%s\t%s\n", name, tel, address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
