package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		boolean result1 = ((i > j) && (++j > h));
//		boolean result2 = ((i < j) && (++j > h));
		System.out.println(result1); // q�Ҹ� ������ ���� and�����ڴ� �տ� �־��� ��(����)�� �����̸�
										// �ڿ� �־��� ��(����)�� �������� �ʴ´�.
//		System.out.println(j);
//		System.out.println(result2);

		result1 = ((i < h) || (++j > h));
		System.out.println(result1);// �Ҹ� ������ or�����ڴ� �տ� �־��� ��(����)�� ���϶� �ڿ� ��(����)�� ���������ʴ´�
		System.out.println(j);
		
//		��Ʈ ����� & |
		int x = 3; // 0 0 1 1
		int y = 1; // 0 0 0 1
		System.out.println(x & y);

	}

}
