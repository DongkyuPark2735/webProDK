package com.lec.ex1_Parking;

public class ParkingTestMain {
	public static void main(String[] args) {

		ParkingClass car1 = new ParkingClass("11�� 1111", 12);
		ParkingClass car2 = new ParkingClass("14�� 0567", 9);
		car1.parkingOut(15);
		car2.parkingOut(15);//����ڿ��� out 15�� �ð� �ޱ�
		car1.parkingOut();//����ڿ��� out�ð��ޱ�
	
	}

}
