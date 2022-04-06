package com.lec.ex5homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date date;
	private String address;

	public Member() {
	}

	public Member(String name, String tel, Date date, String address) {
		this.name = name;
		this.tel = tel;
		this.date = date;
		this.address = address;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdp = new SimpleDateFormat("MM¿ù dd»ý");
		return name + "\t" + tel + "\t" + sdp.format(date) + "\t" + address;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
