package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {

		String tot = sum(10);
		System.out.println(sum(99));
//		System.out.println(evenOdd(tot));
		// from ~to���� �����Ѵ� ����
		// ¦Ȧ�� �Ǻ� ����);

//		tot = sum(10, 100);
		System.out.println("10���� 100���� �������� " + tot);
//		System.out.println(evenOdd(tot));
		// from~to���� �����ϴ� ����
	}

	private static String sum(int to) {// �����ε� �Ű�����(�Ķ����) ������
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return "1���� " + to + "���� �������� " + result;
	}

	private static int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

//	private static String evenOdd(String value) {
//		String result = null;
//		if(value %2==0) {
//			result = "¦���Դϴ�.";			
//		}else {
//			result = "Ȧ���Դϴ�.";			
//		}
////		return result;
//
//		return (String)value % 2 == 0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
	}


