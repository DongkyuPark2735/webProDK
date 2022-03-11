package com.lec.ex;

public class VarEx05 {
	public static void main(String[] args) {
		char c = '씨';
		long l = 2200000000L;
		float f1, f2;
		f1 = 10.1f;
		f2 = 100.1f;
		double d = 3.14159265359d;
		boolean b = true;

		System.out.println("f1=" + f1);
		f1 = 10.0000017f;
		double x = 10.0000017;
		System.out.println("f1=" + f1);
		System.out.println("x=" + x);
		f1 = 10.1f;
		d = 10.0;
		if (f1 == d) {
			System.out.println("두 변수는 같다");
		} else {
			System.out.println("두변수는 다르다");
		}
//		참조 데이터 타입 알아볼것
		
		System.out.println("C는 " + c);
		System.out.println("l는 " + l);

		System.out.println("f는 " + f1);
		System.out.println("d는 " + d);
		System.out.println("b는 " + b);

	}
}
