package com.lec.ex5_car;

import com.lec.cons.Constant;

public abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay();

	public final double computeIncentive() {
		if (computePay() > 2000000) {//�޼��� ���� �ð��� ���ϰ�
			//�ٸ� ������ �����ߴٰ� ������ �ҷ�����. �żҵ� ������ �ҷ����°��� �ٿ���
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
