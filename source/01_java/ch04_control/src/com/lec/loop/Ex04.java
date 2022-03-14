package com.lec.loop;

//1~40까지 한줄에 4개씩 출력
public class Ex04 {
	public static void main(String[] args) {
		for (int i = 1; i < 41; i++) {
			System.out.print(i + "\t");
			if (i % 4 == 0) {
				System.out.println();
			}
		}

	}
}
