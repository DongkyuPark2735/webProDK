package com.lec.ex;
/* ■■■■■■■■■■■■■■■
 * Hello, world!
 * ---------------
 * Hello, java!
 * ~~~~~~~~~~~~~~
 * Hello, Hong!
 * ■■■■■■■■■■■■■■■
 */

public class Ex05_line {
	public static void main(String[] args) {
		printLine('■', 50);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, World!");
		printLine('~');
		System.out.println("\tHello, World!");
		printLine('■', 40);
	}// 변수에 할당하지않음 -- 리턴값 없음
		// 리턴타입이 없고 매개변수 없는 매소드(함수)

	private static void printLine(char c, int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
		}
		

	
	private static void printLine(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print('-');
		}
		System.out.println();//프린트 함수값이 리턴되는게 아닌지? 
	}

	private static void printLine(char c) {// 매개변수 만 달리하면 함수 오버로딩, 매개변수 타입과 갯수로 구분
		for (int i = 0; i < 30; i++) {
			System.out.print(c);
		}
		System.out.println();// 전달받은 매개변수 c(문자) 를 출력
	}

	private static void printLine() {
		for (int i = 0; i < 30; i++) {
			System.out.print('-');
		}
		System.out.println();// 얇은 선 출력
	}

}
