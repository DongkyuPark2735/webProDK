package com.lec.ex14_account;

import org.omg.CORBA.PERSIST_STORE;

public class TestMain {

	public static void main(String[] args) {

		AccountClass person2;// 매개변수 없는 생성자 생성할것
		person2 = new AccountClass("222-2", "Park");
		person2.deposit(3000);
		person2.deposit(6000);
		person2.withdraw(10000);
//		System.out.println(person2.infoPrint());
//		
		CheckingAccount person1 = new CheckingAccount("111-1", "Kim", 100000, "1234-1234-1234-1234");
		person1.deposit(9000);
		person1.withdraw(20000);
		person1.pay("1234-1234-1234-1234", 200000);
		person1.pay("1234-1234-1234-1231", 20000);
		person1.pay("1234-1234-1234-1234", 2000);
//		System.out.println(person1.infoPrint());
//
		CreditLineAccount person3 = new CreditLineAccount("112-2", "park", 5000, "123-123-123-123", 5000000);
		person3.deposit(10000);
	    person3.pay("123-123-123-123", 5000001);;
//		System.out.print(person3.infoPrint());
//
//		System.out.println(person1.infoPrint());

	}
}
