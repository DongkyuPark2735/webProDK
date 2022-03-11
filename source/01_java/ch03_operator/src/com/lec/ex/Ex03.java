package com.lec.ex;

import javax.naming.spi.DirStateFactory.Result;

public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10, n2 = 20;
		boolean result;
		result = n1 > n2;
		System.out.printf("%d %c %d = %b\n", n1, '>', n2, result);
		result = n1 == n2;
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);

	}
}
