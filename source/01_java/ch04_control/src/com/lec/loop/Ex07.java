package com.lec.loop;

//1~100���� 3�� ����� �ո� ������ ����� ?
public class Ex07 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while (++i < 101) {
			if (i % 3 == 0) {
				sum += i;
			}
			++i;
		}

//		for(int i = 1; i<=100; i++ ) {
//			if(i%3==0) {
//				sum +=i;
//				System.out.println(i);
//			}
//		}
		System.out.println("��������" + sum);
	}
}
