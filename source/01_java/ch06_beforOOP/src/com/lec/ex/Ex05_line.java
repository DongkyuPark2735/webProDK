package com.lec.ex;
/* ����������������
 * Hello, world!
 * ---------------
 * Hello, java!
 * ~~~~~~~~~~~~~~
 * Hello, Hong!
 * ����������������
 */

public class Ex05_line {
	public static void main(String[] args) {
		printLine('��', 50);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, World!");
		printLine('~');
		System.out.println("\tHello, World!");
		printLine('��', 40);
	}// ������ �Ҵ��������� -- ���ϰ� ����
		// ����Ÿ���� ���� �Ű����� ���� �żҵ�(�Լ�)

	private static void printLine(char c, int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
		}
		

	
	private static void printLine(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print('-');
		}
		System.out.println();//����Ʈ �Լ����� ���ϵǴ°� �ƴ���? 
	}

	private static void printLine(char c) {// �Ű����� �� �޸��ϸ� �Լ� �����ε�, �Ű����� Ÿ�԰� ������ ����
		for (int i = 0; i < 30; i++) {
			System.out.print(c);
		}
		System.out.println();// ���޹��� �Ű����� c(����) �� ���
	}

	private static void printLine() {
		for (int i = 0; i < 30; i++) {
			System.out.print('-');
		}
		System.out.println();// ���� �� ���
	}

}
