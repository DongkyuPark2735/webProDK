package com.lec.ex07_book2;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {

		BookLip[] b1 = { new BookLip("111", "java", "홍길동"), new BookLip("222", "oracle", "신길동"), new BookLip("333", "mysql", "유길동"),
				new BookLip("444", "web", "고길동"), new BookLip("555", "jsp", "김길동") };

		Scanner scanner = new Scanner(System.in);

		int fn;// 기능번호 1.대출 2.반납 3.책 list 0. 종료
		int idx; // 대출하거나 반납하려고 할때 조회된 책의 index //모든 for문을 함유하기위해 전역변수로 선언
		String bTitle, borrower, checkOutDate;// 대출받을 책이름, 대출인, 대출일

		do {
			System.out.println("1.대출 2.반납 3.책 list 0. 종료");
			fn = scanner.nextInt();
			switch (fn) {
			case 1:// 대출 : 1.책이름 입력 2.책 조회 3.책 상태 확인 4.대출인입력 5.대출일 입력 6.대출매소드 호출
				System.out.println("대출 하고자 하는 책 이름은?");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음
				// 2. 책조회
				for (idx = 0; idx < b1.length; idx++) {
					if (bTitle.equals(b1[idx].getBookTitle())) {
						break;
					}
				} // 책조회 for
				if (idx == b1.length) {// idx가 0이 아니니까?
					System.out.println("현재 보유하지 않은 도서입니다.");
				} else {// book[idx] 도서를 대출처리
						// 3.책상태확인
					if (b1[idx].getState() == BookLip.STATE_BORROWED) {// 대출불가 상태
						System.out.println("현재 대출중인 도서입니다.");
					} else {// 대출가능상태
							// 4.대출인 입력 5. 대출일 입력 6. 대출매소드 호출
						System.out.println("대출자는 ?");
						borrower = scanner.next();
						System.out.println("대출일은 ?");
						checkOutDate = scanner.next();
						b1[idx].checkOut(borrower, checkOutDate);

					}
				}
				break;
			case 2:// 반납 : 1.책이름 2.책조회 3.반납
				System.out.print("반납할 책 이름은?");
				bTitle = scanner.next();
				// 2.책조회
				for (idx = 0; idx < b1.length; idx++) {
					if (bTitle.equals(b1[idx].getBookTitle())) {
						break;
					}
				}
				// idx가 찾은 위치
				if (idx == b1.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				} else {// idx가 찾은 위치
						// 3.반납
					b1[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("책 리스트는 다음과 같습니다.");
				for (BookLip i : b1) {
					i.printState();
				}

				break;
			}
		} while (fn != 0);
		System.out.println("안녕히 가세요");
//		while(true) {
//			System.out.println("1.대출 2.반납 3.책 list 0. 종료");
//			fn = scanner.nextInt();
//			if(fn==0) {
//				break;
//			}
//		}

	}
}
