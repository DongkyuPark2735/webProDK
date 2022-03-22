package com.lec.ex14_account;

//CreditLineAccount c2 = new CreditLineAccount("11-11","ȫ","111...,100000)
//CreditLineAccount c2 = new CreditLineAccount("11-11","ȫ",1000,"111...,100000)
public class CreditLineAccount extends CheckingAccount {
	private int creditline;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditline) {
		super(accountNo, ownerName, cardNo);
		this.creditline = creditline;
		System.out.printf("�ſ�ī�尡 �����Ǿ����ϴ�. �ѵ�%d\n", creditline);
	}

	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditline) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditline = creditline;
		System.out.printf("�ſ�ī�尡 �����Ǿ����ϴ�. �ѵ�%d\n", creditline);
	}

	@Override
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(getCardNo())) {
			if (creditline >= amount) {
				creditline -= amount;
				System.out.printf("%s�� ���� %s�� %d�� �����Ͽ� �ѵ�%d�� ���ҽ��ϴ�.\n", getOwnerName(), getAccountNo(), amount,
						creditline);
			} else {
				System.out.printf("%s�� ���� %s��  �ѵ�%d������ %d�� ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), creditline,
						amount);
			}
		} else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���");
		}
	}
}
