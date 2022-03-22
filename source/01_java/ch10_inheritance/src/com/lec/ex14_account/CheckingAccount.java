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
		System.out.printf("ī���ȣ��%s\n",cardNo);
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.printf("ī���ȣ��%s\n",cardNo);
	}

	public void pay(String cardNo, int amount) {
		if (this.cardNo.equals(cardNo)) {
			if (getBalance() >= amount) {
				setBalance(getBalance() - amount);
				System.out.printf("%s�� ���� %s�� �ܾ� %d�� �����Ͽ� �ܾ�%d�� ���ҽ��ϴ�.\n",
						getOwnerName(), getAccountNo(), amount, getBalance());
			} else {
				System.out.printf("%s�� ���� %s�� �ܾ� %d������ %d�� ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), getBalance(),
						amount);
			}
		} else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���");
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	

}
