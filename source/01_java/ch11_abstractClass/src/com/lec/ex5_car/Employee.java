package com.lec.ex5_car;

import com.lec.cons.Constant;

public abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay();

	public final double computeIncentive() {
		if (computePay() > 2000000) {//메서드 로직 시간을 줄일것
			//다른 변수에 저장했다가 변수를 불러낸다. 매소드 여러번 불러내는것을 줄여줌
			return (computePay() * Constant.INCENTIVEPERSENT);
		} else {
			return 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
