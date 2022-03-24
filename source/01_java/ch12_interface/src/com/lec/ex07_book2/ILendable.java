package com.lec.ex07_book2;

//Book 작업명세
public interface ILendable {
	public byte STATE_BORROWED = 1;// "대출중
	public byte STATE_NORMAL = 0;//

	public void checkOut(String borrower, String checkoutDate);// 대출시 대출인과 대출일 이용

	public void checkIn(); // 반납

	public void printState();// 도서 정보와 대출 상태 출력

}
