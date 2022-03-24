//package com.lec.ex07_book2;
//
//import java.util.Scanner;
//
//public class TestMain2 {
//	public static void main(String[] args) {
//		CDLib[] cdarr = { new CDLib("100", "java", "100"), new CDLib("104", "oracle", "104"),
//				new CDLib("101", "python", "101"), new CDLib("102", "jsp", "102"), new CDLib("103", "ruby", "103") };
//
//		Scanner scanner = new Scanner(System.in);
//
//		int idx, no;
//		String CTitle;
//
//		do {
//			System.out.println("1.대출  | 2.반납 | 3. 상태 | 0.종료");
//			no = scanner.nextInt();
//			switch (no) {
//			case 1:
//				System.out.println("대출할 도서를 입력하세요");
//				CTitle = scanner.next();
//				for (idx = 0; idx > cdarr.length; idx++) {
//					if (cdarr[idx]) {
////					if (CTitle.equals(cdarr[idx].getCdTitle())) {
//						
//					}
//
//				}
//
//				break;
//			case 2:
//
//			case 3:
//			default:
//				break;
//			}
//
//		} while (no != 0);
//		System.out.println("안녕히 가십시오");
//	}
//}
