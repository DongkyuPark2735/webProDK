package com.lec.ex3_account;

import org.omg.CORBA.PERSIST_STORE;

public class AccountTestPerson_1 {

	public static void main(String[] args) {

		AccountClass person2;// 매개변수 없는 생성자 생성할것
		person2 = new AccountClass("222-2", "Park");
		person2.deposit(10000000000l);
		person2.withdraw(30000000);
		System.out.println(person2.infoPrint());
		
		AccountClass person1 = new AccountClass("111-1", "Kim", 100000);
		person1.deposit(10000);
		person1.withdraw(1000);
		System.out.println(person1.infoPrint());

		AccountClass person3 = new AccountClass();
		person3.setAccountNo("333-3");
		person3.setBalance(1000000000);
		person3.setOwnerName("Hwang");
		System.out.print(person3.infoPrint());

		System.out.println(person1.infoPrint());

	}

}
