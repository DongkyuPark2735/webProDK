package com.lec.ex3_student;

public class StudentDTO {
	private String rank;
	private int sno;
	private String sname;
	private String mname;
	private int score;
	private static int UNEXPEL = 0;
	private static int EXPEL = 1;

	public StudentDTO() {
	}

	public StudentDTO(String sname, String mname, int score) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	public StudentDTO(String rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	@Override
	public String toString() {
		return sno + "\t" + sname + "\t" + mname + "\t" + score + "\n";
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEXPEL() {
		return EXPEL;
	}

	public void setEXPEL(int eXPEL) {
		EXPEL = eXPEL;
	}

	public int getUNEXPEL() {
		return UNEXPEL;
	}

	public void setUNEXPEL(int uNEXPEL) {
		UNEXPEL = uNEXPEL;
	}

}
