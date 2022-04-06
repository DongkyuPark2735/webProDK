package com.lec.ex5_atm;

//ATM a = new ATM(100000)
public class ATM {

	private int balance;

	public ATM(int balance) {
		this.balance = balance;
	}

	public synchronized  void deposit(int amount, String who) {
		System.out.println(who + " 입금시작 ~~~");
		balance += amount;
		System.out.println(who + "가" + amount + " 원 입금하여 잔액 : " + balance);
		System.out.println(who + "가 입금종료");
	}

	public  synchronized void withdrow(int amount, String who) {
		System.out.println(who + " 출금시작@@@");
		balance -= amount;
		System.out.println(who + "가" + amount + "원 출금하여 잔액 : " + balance);
		System.out.println(who + "가 출금종료");
	}

	public int getBalance() {
		return balance;
	}

}
