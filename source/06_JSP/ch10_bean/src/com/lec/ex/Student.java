package com.lec.ex;

public class Student {
	private String sno;
	private String name;
	private int grade;
	private int sclass;
	private int score;
	
	public Student() {
	}

	public Student(String sno, String name, int grade, int sclass, int score) {
		this.sno = sno;
		this.name = name;
		this.grade = grade;
		this.sclass = sclass;
		this.score = score;
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSclass() {
		return sclass;
	}
	public void setSclass(int sclass) {
		this.sclass = sclass;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
