package com.lec.ex05_test;

public class TestMain {

	public static void main(String[] args) {

		TestChildClass tc = new TestChildClass();
		tc.m1();
		tc.m2();
		tc.m3();
		tc.m11();
		System.out.println(I11.i11);
		System.out.println(TestChildClass.i11);
		System.out.println(I1.i1);
	}
}
