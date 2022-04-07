package com.lec.test;
import java.util.Date;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public Friend() {
	}
	public Friend(String name, String address, String phone, String birthday) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return String.format("�̸� : %s \n�� �� : %s \n�ڵ��� : %s \n�� �� : %s" , name, address, phone, birthday);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
