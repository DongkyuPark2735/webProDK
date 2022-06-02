package com.lec.friend;

public class FriendDto {
	private int fno;
	private String fname;
	private String ftel;
	
	
	public FriendDto() {
	}

	public FriendDto(int fno, String fname, String ftel) {
		super();
		this.fno = fno;
		this.fname = fname;
		this.ftel = ftel;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtel() {
		return ftel;
	}

	public void setFtel(String ftel) {
		this.ftel = ftel;
	}

	@Override
	public String toString() {
		return "FriendDto [fno=" + fno + ", fname=" + fname + ", ftel=" + ftel + "]";
	}
	
}
