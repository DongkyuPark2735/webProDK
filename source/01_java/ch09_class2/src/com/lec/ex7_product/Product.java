package com.lec.ex7_product;

public class Product {
	private int serialNo; // ��ü ������ȣ 101.. 102..
	public static int count = 100;// ��ü�ȿ� ������
	//������ ���������� ��ü ���� 
	public Product() {
		serialNo = ++count;//�����ؼ� ����
		//count�� ���������̹Ƿ� 
	}
	public static void info1() {
		count =+ count;
	}

	public void infoPrint() {
		System.out.println("serialNo+ " + serialNo + "\t�������� count = " + count);
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	
}
