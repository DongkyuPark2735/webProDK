package com.lec.adminDTO;

public class AdminDTO {
	private String aid;
	private String apw;
	private String aname;

	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String aid, String apw, String aname) {
		super();
		this.aid = aid;
		this.apw = apw;
		this.aname = aname;
	}
	
	@Override
	public String toString() {
		return "AdminDTO [aid=" + aid + ", apw=" + apw + ", aname=" + aname + "]";
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getApw() {
		return apw;
	}

	public void setApw(String apw) {
		this.apw = apw;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

}
