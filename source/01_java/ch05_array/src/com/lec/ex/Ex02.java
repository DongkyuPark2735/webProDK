package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		// Ȯ��for���� �迭 ����Ҷ�
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
		for (int temp : arr) {// �迭 Ư�� ���� ������� �迭�� ��系�� ����ҋ�
			// : = Ȯ��for�� : ���� �迭�� �־ :���� ������ �迭���� �ϳ��ϳ� �ִ´�.
			System.out.println(temp);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 5;
		}
		for (int temp : arr) {//
			temp = 9;
			System.out.println(temp);
		}
//		System.out.println("������");
		for (int temp : arr) {//
			System.out.println(temp);
			
		}
	}
}
