package com.lec.ex07_book2;

//Book b = new Book ("890", "java", "ȫ�浿")
public class BookLip extends BookInfo implements ILendable {
	private String borrower; //
	private String checkOutDate;// ������
	private byte state;// ������ (1), ���� ����(0)

	public BookLip(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);

	}

	// b.checkOut("�ű浿","03-23")
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(super.getBookTitle() + "���� �� �� �����ϴ�.");
			return;// void���� return ���� return�� ���� �Է�����������
		}
		// state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(super.getBookTitle() + " ������ ���� ó���Ǿ����ϴ�.");
		System.out.println("������ :" + borrower + "\t������ : " + checkOutDate);

	}

	// b.checkIn //���� ����0 �̸� �޼��� �Ѹ��� �ߴ�, ������1 �̸� �ݳ�����
	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(super.getBookTitle() + " ������ �ݳ��� �� �����ϴ�.");
			return;
		} // state�� ������(1)�̶� �ݳ�����
		state = STATE_NORMAL;
		borrower = null;
		checkOutDate = null;
		System.out.println(super.getBookTitle() + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + ")";
//		msg = msg + ((state == STATE_NORMAL) ? "���Ⱑ��" : (state == STATE_BORROWED) ? "������" : "�̻���");
//		System.out.println(msg);
		if (state == STATE_NORMAL) {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + ") ���Ⱑ��");
		} else if (state == STATE_BORROWED) {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + ") ������");
		} else {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + ") �̻���");
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
