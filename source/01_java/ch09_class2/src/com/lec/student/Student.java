package com.lec.student;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private double avg;
	private static int countNum;
	private int no;

	public Student() {
	}

	public Student(String name, int kor, int eng, int mat) {
		no = ++countNum;
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

	public static void textPrint() {
		for (int i = 0; i < 50; i++) {
			System.out.print('■');
		}
		System.out.println("\n\t\t\t성적표 ");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println("\n 번호\t이름\t" + "국어\t" + "영어\t" + "수학\t" + "총점\t" + "평균");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();// String?

	}
	
	public void totPrint() {
		
	}
	
	public String perInfo() {

		return String.format(" %d"+"\t%s" +"\t%d" +"\t%d" +"\t%d" +"\t%d" +"\t%.2f",no, name, kor, eng,mat,subTotal(),averige());
					
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
