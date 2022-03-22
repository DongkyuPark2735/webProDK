package com.lec.ex14_account;

//CreditLineAccount c2 = new CreditLineAccount("11-11","홍","111...,100000)
//CreditLineAccount c2 = new CreditLineAccount("11-11","홍",1000,"111...,100000)
public class CreditLineAccount extends CheckingAccount {
	private int creditline;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditline) {
		super(accountNo, ownerName, cardNo);
		this.creditline = creditline;
		System.out.printf("신용카드가 개설되었습니다. 한도%d\n", creditline);
	}

	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditline) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditline = creditline;
		System.out.printf("신용카드가 개설되었습니다. 한도%d\n", creditline);
	}

	@Override
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(getCardNo())) {
			if (creditline >= amount) {
				creditline -= amount;
				System.out.printf("%s님 계좌 %s의 %d원 지불하여 한도%d원 남았습니다.\n", getOwnerName(), getAccountNo(), amount,
						creditline);
			} else {
				System.out.printf("%s님 계좌 %s의  한도%d원으로 %d원 지불 불가합니다.\n", getOwnerName(), getAccountNo(), creditline,
						amount);
			}
		} else {
			System.out.println("올바른 카드번호를 입력하세요");
		}
	}
}
