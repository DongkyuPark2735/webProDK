package com.lec.ex7_product;

public class Product {
	private int serialNo; // 객체 고유번호 101.. 102..
	public static int count = 100;// 객체안에 안잡힘
	//데이터 공간영역에 객체 생성 
	public Product() {
		serialNo = ++count;//증가해서 대입
		//count가 공유변수이므로 
	}
	public static void info1() {
		count =+ count;
	}

	public void infoPrint() {
		System.out.println("serialNo+ " + serialNo + "\t공유변수 count = " + count);
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	
}
