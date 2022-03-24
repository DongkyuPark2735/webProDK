package com.lec.ex07_book2;

import com.lec.ex07_book1.ILendable;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;

	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
	}

	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_NORMAL) {
			this.borrower = borrower;
			this.checkOutDate = checkoutDate;
			state = STATE_BORROWED;
			System.out.println("�ش� CD�� ����Ǿ����ϴ�.");
			return;
		}
		System.out.println("�ش� CD�� ���� �Ҽ������ϴ�.");
	}

	
	@Override
	public void checkIn() {
		if(state == STATE_BORROWED) {
			this.borrower = null;
			this.checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("�ش� CD�� �ݳ��Ǿ����ϴ�.");
		}
		System.out.println("�ش� CD�� �ݳ� �Ҽ������ϴ�.");
		return;
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(super.getBookNo() + "\t" + super.getCdTitle() + "(" + super.getCdNo() + ") ���Ⱑ��");
		} else if (state == STATE_BORROWED) {
			System.out.println(super.getBookNo() + "\t" + super.getCdTitle() + "(" + super.getCdNo() + ") ������");
		} else {
			System.out.println(super.getBookNo() + "\t" + super.getCdTitle() + "(" + super.getCdNo() + ") �̻���");
		}
	
		
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
	

}
