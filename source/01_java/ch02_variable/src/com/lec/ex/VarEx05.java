package com.lec.ex;

public class VarEx05 {
	public static void main(String[] args) {
		char c = '��';
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
			System.out.println("�� ������ ����");
		} else {
			System.out.println("�κ����� �ٸ���");
		}
//		���� ������ Ÿ�� �˾ƺ���
		
		System.out.println("C�� " + c);
		System.out.println("l�� " + l);

		System.out.println("f�� " + f1);
		System.out.println("d�� " + d);
		System.out.println("b�� " + b);

	}
}
