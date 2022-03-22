package com.lec.ex14_account;

public class AccountClass {
//������ ����
	private String accountNo;
	private String ownerName;
	private long balance;

//�Ӽ� ==�ν��Ͻ� == �ɹ�����
//�������Լ�
//	public AccountClass() {
//
//	}

	public AccountClass(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s���� ���� %s�� �����Ǿ����ϴ�. �ܾ��� %,d\n", ownerName, accountNo, balance);
	}

	public AccountClass(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s���� ���� %s�� �����Ǿ����ϴ�. �����Աݾ��� �����ϴ�.\n", ownerName, accountNo);
	}

//method
	public void deposit(long deposit) {// �Ա�
		if (deposit <= 0) {
			System.out.println("��ȿ�������� �����Դϴ�.\n");
		} else {
			this.balance += deposit;
			System.out.printf("%s���� ���� %s��  %,d�� �ԱݵǾ����ϴ�. ���� �ܾ��� %,d��\n", ownerName, accountNo, deposit, this.balance);
		}
	}

	public void withdraw(long balance) {// ���
		if (balance > this.balance) {
			System.out.printf("�ܾ��� �����մϴ�. ���� �ܾ��� %,d��\n", this.balance);
		} else {
			this.balance -= balance;
			System.out.printf("%s���� ���� %s��  %,d�� ��ݵǾ����ϴ�. ���� �ܾ��� %,d��\n", ownerName, accountNo, balance, this.balance);
		}
	}
//	public String status(String accountNo, String ownerName) {
//		
//		System.out.printf("%c ���� ���� %c�� ���� �ܾ��� %d", );
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

//�ܾ���ȸ
	public String infoPrint() {
		return String.format("%s���� ���� %s�� �ܾ��� %,d��\n", ownerName, accountNo, balance);
	}

}
