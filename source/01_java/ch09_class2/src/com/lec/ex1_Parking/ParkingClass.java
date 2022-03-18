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
		System.out.printf("%s 차량 어서오세요.\n입차시간은 %d입니다.\n주차요금은 시간당 %d입니다.\n"
				, this.carNum, this.inTime,Constant.PRICE);
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
//객체에 있는 데이터도 바꿀것 
//inTime도 출차할떄 수정
	public void parkingOut(int outTime) {
		this.outTime = outTime;
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("%s 차량 안녕히 가십시요.\n입차 시간 : %d시 \n출차 시간 : %d시\n주차 시간 :%d시간\n"
				, carNum, inTime, outTime,(outTime - inTime));
		sum = ((outTime - this.inTime) * Constant.PRICE);
		System.out.println("주차요금은 " + sum + "원입니다.");
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void parkingOut() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("출차하는 시간을 입력하세요");
		outTime = scanner.nextInt();
//		inTime > outTime ? System.out.println("출차시간은 입차시간보다 커야합니다.") : parkingOut(outTime);
		parkingOut(outTime);
		scanner.close();
	}
	

}
