package com.lec.ex0_janmuri;

//public class Quiz2{
	
//}
public class Quiz1{ // ������
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private double avg;

	public Quiz1() {// �⺻������
	}

	public Quiz1(String name, int kor, int eng, int mat) {// �Ű����� �ִ� ������
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int subTotal() {
//		sum = kor + eng + mat;
		return kor + eng + mat;
	}

	public double averige() {
//		avg = ((kor + eng + mat) / 3.0);
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