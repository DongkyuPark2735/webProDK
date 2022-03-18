package com.lec.ex1_Parking;

import java.util.Scanner;

import com.lec.cons.Constant;

public class ParkingClass {
	private String carNum;
	private int inTime;
	private int outTime;
//	private final int PRICE = 500;
	private int sum;

	public ParkingClass() {
		
	
	}
	
	public ParkingClass(String carNum, int inTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		System.out.println();
		System.out.printf("%s ���� �������.\n�����ð��� %d�Դϴ�.\n��������� �ð��� %d�Դϴ�.\n"
				, this.carNum, this.inTime,Constant.PRICE);
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
//��ü�� �ִ� �����͵� �ٲܰ� 
//inTime�� �����ҋ� ����
	public void parkingOut(int outTime) {
		this.outTime = outTime;
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("%s ���� �ȳ��� ���ʽÿ�.\n���� �ð� : %d�� \n���� �ð� : %d��\n���� �ð� :%d�ð�\n"
				, carNum, inTime, outTime,(outTime - inTime));
		sum = ((outTime - this.inTime) * Constant.PRICE);
		System.out.println("��������� " + sum + "���Դϴ�.");
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void parkingOut() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����ϴ� �ð��� �Է��ϼ���");
		outTime = scanner.nextInt();
//		inTime > outTime ? System.out.println("�����ð��� �����ð����� Ŀ���մϴ�.") : parkingOut(outTime);
		parkingOut(outTime);
		scanner.close();
	}
	

}
