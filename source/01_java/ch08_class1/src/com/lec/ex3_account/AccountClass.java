package com.lec.ex3_account;

public class AccountClass {
//데이터 선언
	private String accountNo;
	private String ownerName;
	private long balance;

//속성 ==인스턴스 == 맴버변수
//생성자함수
	public AccountClass() {

	}

	public AccountClass(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s님의 계좌 %s로 개설되었습니다. 잔액은 %,d\n", ownerName, accountNo, balance);
	}

	public AccountClass(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s님의 계좌 %s가 개설되었습니다. 개설입금액은 없습니다.\n", ownerName, accountNo);
	}

//method
	public void deposit(long deposit) {// 입금
		if (deposit <= 0) {
			System.out.println("유효하지않은 범위입니다.\n");
		} else {
			this.balance += deposit;
			System.out.printf(" %,d가 입금되었습니다. 현재 잔액은 %,d원\n", deposit, this.balance);
		}
	}

	public void withdraw(long balance) {//출금
		if(balance > this.balance) {
			System.out.printf("잔액이 부족합니다. 현재 잔액은 %,d원\n", this.balance);
		}else {
			this.balance -= balance; 
			System.out.printf(" %,d가 출금되었습니다. 현재 잔액은 %,d원\n", balance, this.balance);			
		}
	}
//	public String status(String accountNo, String ownerName) {
//		
//		System.out.printf("%c 님의 계좌 %c의 현재 잔액은 %d", );
//	}

//account
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

//owner
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

///balance
	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
//잔액조회
	public String infoPrint() {
		return String.format("%s님의 계좌 %s의 잔액은 %,d원\n", ownerName, accountNo, balance );
	}

}
