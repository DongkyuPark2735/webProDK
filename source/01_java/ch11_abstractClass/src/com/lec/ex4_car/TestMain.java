package com.lec.ex4_car;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
//		Car c1 = new LowGradeCar("빨강", "일반", 1000, "일반");
		//상수용 클래스 만들어서 상수 사용  
		//변경사항있으면 메인함수 수정 지향  텍스트파일을 수정하는것을 지향?
		//기존의 소스는 고치지않는다. 클래스 새로 만들고 메인함수 바꿀것
		Car car = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NOMAL, CarSpec.DISPLACEMENT_1000, CarSpec.HANDDLE_NORMAL);
		Car car1 = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WHILD, CarSpec.DISPLACEMENT_2000, CarSpec.HANDDLE_POWER);
		car.getSpec();
		car1.getSpec();
		
	}

}
