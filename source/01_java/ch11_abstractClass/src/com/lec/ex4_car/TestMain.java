package com.lec.ex4_car;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
//		Car c1 = new LowGradeCar("����", "�Ϲ�", 1000, "�Ϲ�");
		//����� Ŭ���� ���� ��� ���  
		//������������� �����Լ� ���� ����  �ؽ�Ʈ������ �����ϴ°��� ����?
		//������ �ҽ��� ��ġ���ʴ´�. Ŭ���� ���� ����� �����Լ� �ٲܰ�
		Car car = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NOMAL, CarSpec.DISPLACEMENT_1000, CarSpec.HANDDLE_NORMAL);
		Car car1 = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WHILD, CarSpec.DISPLACEMENT_2000, CarSpec.HANDDLE_POWER);
		car.getSpec();
		car1.getSpec();
		
	}

}
