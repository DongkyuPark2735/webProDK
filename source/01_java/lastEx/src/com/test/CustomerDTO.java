package com.test;

public class CustomerDTO {
	private int cno;
	private String cphone;
	private String cname;
	private int cpoint;
	
	
	public CustomerDTO(int cno, String cphone, String cname, int cpoint) {
		super();
		this.cno = cno;
		this.cphone = cphone;
		this.cname = cname;
		this.cpoint = cpoint;
	}


	@Override
	public String toString() {
		return cno + "\t" + cphone + "\t" + cname + "\t" + cpoint;
	}


	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
}
