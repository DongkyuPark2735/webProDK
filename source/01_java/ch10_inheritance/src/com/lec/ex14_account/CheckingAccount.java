package com.lec.ex14_account;

//a2.pay("1111-1111-1111-1111", 1000);
public class CheckingAccount extends AccountClass {
	private String cardNo;

//	public CheckingAccount() {
//		super();
//	}

	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.printf("카드번호는%s\n",cardNo);
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.printf("카드번호는%s\n",cardNo);
	}

	public void pay(String cardNo, int amount) {
		if (this.cardNo.equals(cardNo)) {
			if (getBalance() >= amount) {
				setBalance(getBalance() - amount);
				System.out.printf("%s님 계좌 %s의 잔액 %d원 지불하여 잔액%d원 남았습니다.\n",
						getOwnerName(), getAccountNo(), amount, getBalance());
			} else {
				System.out.printf("%s님 계좌 %s의 잔액 %d원으로 %d원 지불 불가합니다.\n", getOwnerName(), getAccountNo(), getBalance(),
						amount);
			}
		} else {
			System.out.println("올바른 카드번호를 입력하세요");
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	

}
