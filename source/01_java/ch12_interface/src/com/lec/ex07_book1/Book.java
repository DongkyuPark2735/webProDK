package com.lec.ex07_book1;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

//Book b = new Book ("890", "java", "홍길동")
public class Book implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책제목
	private String writer; // 책저자
	private String borrower; //
	private String checkOutDate;// 대출일
	private byte state;// 대출중 (1), 대출 가능(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;

	}

	// b.checkOut("신길동","03-23")
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(bookTitle + "대출 할 수 없습니다.");
			return;// void여도 return 가능 return에 값을 입력하지않으면
		}
		// state가 0이라서 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + " 도서가 대출 처리되었습니다.");
		System.out.println("대출인 :" + borrower + "\t대출일 : " + checkOutDate);

	}

	// b.checkIn //대출 가능0 이면 메세지 뿌리고 중단, 대출중1 이면 반납진행
	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(bookTitle + " 도서는 반납할 수 없습니다.");
			return;
		} // state가 대출중(1)이라 반납진행
		state = STATE_NORMAL;
		borrower = null;
		checkOutDate = null;
		System.out.println(bookTitle + " 도서가 반납 완료되었습니다.");
	}

	@Override
	public void printState() {
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + ")";
//		msg = msg + ((state == STATE_NORMAL) ? "대출가능" : (state == STATE_BORROWED) ? "대출중" : "이상해");
//		System.out.println(msg);
		if (state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") 대출중");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") 이상해");
		}
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
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
