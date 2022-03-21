package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {

		Customer customer = new Customer("홍", "010-9999-9999", "서울", "1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());

		Person staff = new Staff("김", "010-8888-8888", "2022-09-01", "개발팀");
		// Staff 타입이지만 person타입도 된다?
		Person person = new Person("이", "010-7777-7777");
		Person[] personArr = { customer, staff, person };
		
		System.out.println(staff.infoString());
		
		for (int i = 0; i < personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		//배열 0~끝방까지 infoSting()
		for(Person a : personArr) {
			System.out.println(a.infoString());
		}
		//buy(1000)
		for(Person a : personArr) {
			if(a instanceof Customer) {//p변수가 Customer형 객체인가?//자료형에 맞는 메서드를 작동할수있는지 확인하는 명령어 
				((Customer)a).buy(1000);				
			}else {
				System.out.println("buy는 Customer만 가능합니다.");
			}
		}
		
	}

}