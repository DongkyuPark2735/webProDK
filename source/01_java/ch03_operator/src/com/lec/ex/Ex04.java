package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		boolean result1 = ((i > j) && (++j > h));
//		boolean result2 = ((i < j) && (++j > h));
		System.out.println(result1); // q불린 연산자 에서 and연산자는 앞에 주어진 값(좌항)이 거짓이면
										// 뒤에 주어진 식(우항)을 실행하지 않는다.
//		System.out.println(j);
//		System.out.println(result2);

		result1 = ((i < h) || (++j > h));
		System.out.println(result1);// 불린 연산자 or연산자는 앞에 주어진 값(좌항)이 참일때 뒤에 항(우항)을 실행하지않는다
		System.out.println(j);
		
//		비트 연산다 & |
		int x = 3; // 0 0 1 1
		int y = 1; // 0 0 0 1
		System.out.println(x & y);

	}

}
