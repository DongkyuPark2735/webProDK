package com.lec.ex07_book2;

//Book b = new Book ("890", "java", "홍길동")
public class BookLip extends BookInfo implements ILendable {
	private String borrower; //
	private String checkOutDate;// 대출일
	private byte state;// 대출중 (1), 대출 가능(0)

	public BookLip(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);

	}

	// b.checkOut("신길동","03-23")
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(super.getBookTitle() + "대출 할 수 없습니다.");
			return;// void여도 return 가능 return에 값을 입력하지않으면
		}
		// state가 0이라서 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(super.getBookTitle() + " 도서가 대출 처리되었습니다.");
		System.out.println("대출인 :" + borrower + "\t대출일 : " + checkOutDate);

	}

	// b.checkIn //대출 가능0 이면 메세지 뿌리고 중단, 대출중1 이면 반납진행
	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(super.getBookTitle() + " 도서는 반납할 수 없습니다.");
			return;
		} // state가 대출중(1)이라 반납진행
		state = STATE_NORMAL;
		borrower = null;
		checkOutDate = null;
		System.out.println(super.getBookTitle() + " 도서가 반납 완료되었습니다.");
	}

	@Override
	public void printState() {
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + ")";
//		msg = msg + ((state == STATE_NORMAL) ? "대출가능" : (state == STATE_BORROWED) ? "대출중" : "이상해");
//		System.out.println(msg);
		if (state == STATE_NORMAL) {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + ") 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + ") 대출중");
		} else {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + ") 이상해");
		}
	}

	public String getBorrower() {
		return borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
}
