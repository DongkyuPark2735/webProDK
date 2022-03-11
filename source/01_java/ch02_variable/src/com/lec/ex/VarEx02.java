package com.lec.ex;

//println() ; 콘솔창에 출력(개행포함)
//print() ; 콘솔창에 출력(개행미포함)
//printf() ; 콘솔창에 특정 포멧으로 출력(개행미포함)
public class VarEx02 {
	public static void main(String[] args) {
		int i = 10; // 4바이트
		byte j = 10; // 2바이트
		double h = 10.15;
		i = 5;
		char c1 = 'A';
		char c2 = 'B';

		System.out.println("i=" + i + "\t j=" + j + "\t h=" + h);
		System.out.print("c1=" + c1 + "\t c2=" + c2 + "\n"); // t는 탭 n은 줄넘기기
		System.out.printf("c1=%c \t c2=%c \n", c1, c2);// %c= 문자 %d= 정수 %f= 실수 %s= 문자열
		System.out.printf("i=%d, j=%d, h=%5.1f \n", i, j, h);
		System.out.println("끝");
	}
}
