package com.lec.ex;

import java.sql.Date;

public class Member {
	private String id;
	private String pw;
	private Date rdate;
	
	
	public Member() { 
	}

	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.rdate = new Date(System.currentTimeMillis()); //생성자가 호출되는 시점
	}



	public Date getRdate() {
		return rdate;
	}


	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
