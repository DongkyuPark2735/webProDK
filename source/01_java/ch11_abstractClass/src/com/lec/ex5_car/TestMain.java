package com.lec.ex5_car;

public class TestMain {

	public static void main(String[] args) {
		Employee[] sawon = {new SalaryEmployee("ȫ�浿", 24000000),
							new SalaryEmployee("������", 70000000),
							new SalaryEmployee("�����", 12000000),
							new HourlyEmployee("ȫ�汸", 100, 7000),
							new HourlyEmployee("������", 120, 8000),
							new HourlyEmployee("�ڵ���", 120, 20000)};
		
		for(Employee i : sawon) {
			System.out.println("~ ~ ~���޸��� ~ ~ ~");
			System.out.println("�� �� : " + i.getName());
			System.out.printf("�� �� : %,d\n", i.computePay());
			System.out.println();
			if(i.computeIncentive() != 0) {
				System.out.printf("������: %,.1f\n", i.computeIncentive());
			}
		}
	}
}
