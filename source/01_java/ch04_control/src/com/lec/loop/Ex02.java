package com.lec.loop;

public class Ex02 {
	public static void main(String[] args) {

		int tot = 0;
		for (int i = 1; i <= 20; i++) {
			tot += i;// tot = tot + i;
			System.out.println(i);
		}
		System.out.println("1~20까지 누적합은" + tot);
	}
}
