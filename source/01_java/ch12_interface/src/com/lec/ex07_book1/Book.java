package com.lec.ex07_book1;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

//Book b = new Book ("890", "java", "ȫ�浿")
public class Book implements ILendable {
	private String bookNo; // å��ȣ
	private String bookTitle; // å����
	private String writer; // å����
	private String borrower; //
	private String checkOutDate;// ������
	private byte state;// ������ (1), ���� ����(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;

	}

	// b.checkOut("�ű浿","03-23")
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(bookTitle + "���� �� �� �����ϴ�.");
			return;// void���� return ���� return�� ���� �Է�����������
		}
		// state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + " ������ ���� ó���Ǿ����ϴ�.");
		System.out.println("������ :" + borrower + "\t������ : " + checkOutDate);

	}

	// b.checkIn //���� ����0 �̸� �޼��� �Ѹ��� �ߴ�, ������1 �̸� �ݳ�����
	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(bookTitle + " ������ �ݳ��� �� �����ϴ�.");
			return;
		} // state�� ������(1)�̶� �ݳ�����
		state = STATE_NORMAL;
		borrower = null;
		checkOutDate = null;
		System.out.println(bookTitle + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + ")";
//		msg = msg + ((state == STATE_NORMAL) ? "���Ⱑ��" : (state == STATE_BORROWED) ? "������" : "�̻���");
//		System.out.println(msg);
		if (state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") ���Ⱑ��");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") ������");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") �̻���");
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
