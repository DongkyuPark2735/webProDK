package com.lec.ex05;

public class TestMain2 {

	public static void main(String[] args) {
		Super c1 = new Child1(10);
		System.out.println("c1.s =" + c1.s);		
//		System.out.println("c1.c1 =" + (c1.c1);//c1의 타입이 Super이기때문에 불가
		System.out.println("c1.c1 =" + ((Child1)c1).c1);//c1변수의 명시적 형변환
														//컴파일 단계에서 에러
//실행단계에선 알수없음?

	}

}
