package com.lec.ex1_Parking;

public class ParkingTestMain {
	public static void main(String[] args) {

		ParkingClass car1 = new ParkingClass("11가 1111", 12);
		ParkingClass car2 = new ParkingClass("14조 0567", 9);
		car1.parkingOut(15);
		car2.parkingOut(15);//사용자에게 out 15로 시간 받기
		car1.parkingOut();//사용자에게 out시간받기
	
	}

}
