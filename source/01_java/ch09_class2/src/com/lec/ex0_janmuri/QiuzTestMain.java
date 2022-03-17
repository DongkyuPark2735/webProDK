package com.lec.ex0_janmuri;

public class QiuzTestMain {

	public static void main(String[] args) {
				
		Quiz1[] person = { new Quiz1("정우성", 90, 90, 90), new Quiz1("김하늘", 90, 90, 91), new Quiz1("황정민", 81, 80, 80),
				new Quiz1("강동원", 80, 80, 80), new Quiz1("유아인", 70, 70, 70) };
		for (int i = 0; i < 50; i++) {
			System.out.print('■');
		}
		System.out.println("\n\t\t\t성적표 ");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println("\n   이름\t" + "국어\t" + "영어\t" + "수학\t" + "총점\t" + "평균");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();//String?
		for(Quiz1 p : person) {//같은 자료형에 넣어야하기때문 
			System.out.printf(p.perInfo()+"\n");	
		}
		for (int i = 0; i < 50; i++) {
			System.out.print('■');
		}
	}
}
