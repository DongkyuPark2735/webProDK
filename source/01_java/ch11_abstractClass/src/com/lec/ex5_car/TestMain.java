package com.lec.ex5_car;

public class TestMain {

	public static void main(String[] args) {
		Employee[] sawon = {new SalaryEmployee("홍길동", 24000000),
							new SalaryEmployee("강동원", 70000000),
							new SalaryEmployee("김고은", 12000000),
							new HourlyEmployee("홍길구", 100, 7000),
							new HourlyEmployee("강동원", 120, 8000),
							new HourlyEmployee("박동규", 120, 20000)};
		
		for(Employee i : sawon) {
			System.out.println("~ ~ ~월급명세서 ~ ~ ~");
			System.out.println("성 함 : " + i.getName());
			System.out.printf("월 급 : %,d\n", i.computePay());
			System.out.println();
			if(i.computeIncentive() != 0) {
				System.out.printf("성과금: %,.1f\n", i.computeIncentive());
			}
		}
	}
}
