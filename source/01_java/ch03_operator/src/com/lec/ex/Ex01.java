package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int n1 = 33, n2 = 10;
		int result; // +-*%�� ���
		double resultdouble;// /�� ���
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		resultdouble = (double) n1 / n2;// ����� �����ϱ� ������ �������� �������� �ƴ� ���·� ����� ����
		System.out.printf("%d %c %d = %3.3f\n", n1, '/', n2, resultdouble);

		if (n1 % 1 == 0) {
			System.out.println("n1�� ¦��");
			System.out.println("n1�� ¦���� ����");
		} else {
			System.out.println("n1�� Ȧ��");
		} // if
		if (n1 % 6 == 0) {
			System.out.println("n1�� 5�� ���");
		} else {
			System.out.println("n1�� 5�� ����� �ƴϴ�");
		}
	}
}
