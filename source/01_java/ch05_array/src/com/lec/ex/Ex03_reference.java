package com.lec.ex;

public class Ex03_reference {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		j = 99;

		System.out.printf("i=%d, j=%d\n", i, j);

		int[] score = { 100, 10, 20, 30, 40 };
		int[] s = score; //Ư�� ������ � ���� ���� ������ � ������ ���� �����ؼ� ���°� �ƴ϶�
						//���� ���� �����Ѽ� �����Ѵ�. �迭�� �ν���Ʈ�� ���� �����ϱ⶧��
						// ���ο� �迭 ���� ���� �迭 ���� �������� �ν���Ʈ�� ���� ���� �Ҵ� �޾ƾ��Ѵ�.
		s[0] = 99;
		System.out.println(s[0]);
		for (int x = 0; x < score.length; x++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", x, score[x], x, s[x]);

		}
	}
}
