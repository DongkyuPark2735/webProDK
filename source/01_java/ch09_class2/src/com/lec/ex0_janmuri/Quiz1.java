package com.lec.ex0_janmuri;

//public class Quiz2{
	
//}
public class Quiz1 { // 데이터
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private double avg;

	public Quiz1() {// 기본생성자
	}

	public Quiz1(String name, int kor, int eng, int mat) {// 매개변수 있는 생성자
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int subTotal() {
		return kor + eng + mat;
	}

	public double averige() {
		return ((kor + eng + mat) / 3.0);
	}

	public String perInfo() {
		return ("   "+name+ "\t" + kor+"\t" + eng+"\t" + mat+"\t"+subTotal()+"\t"+averige() );
	}

//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

}
