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
			System.out.println("해당 CD가 대출되었습니다.");
			return;
		}
		System.out.println("해당 CD는 대출 할수없습니다.");
	}

	
	@Override
	public void checkIn() {
		if(state == STATE_BORROWED) {
			this.borrower = null;
			this.checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println("해당 CD가 반납되었습니다.");
		}
		System.out.println("해당 CD는 반납 할수없습니다.");
		return;
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(super.getBookNo() + "\t" + super.getCdTitle() + "(" + super.getCdNo() + ") 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(super.getBookNo() + "\t" + super.getCdTitle() + "(" + super.getCdNo() + ") 대출중");
		} else {
			System.out.println(super.getBookNo() + "\t" + super.getCdTitle() + "(" + super.getCdNo() + ") 이상해");
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
