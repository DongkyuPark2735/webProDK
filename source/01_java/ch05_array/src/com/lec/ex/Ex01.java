package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int[] iArr = { 10, 20, 30, 40, 50 };
		iArr[2] = 300; // �迭�� index�� ����(0~4) = iArr.length-1 ����

		for (int idx = 0; idx < iArr.length; idx++) {
			System.out.println(iArr[idx]);
		}
//		���۷��� ������ ���ȿ� �ּ�  �迭���� ����� �迭 �޸� ����Ȯ�� = �迭ũ������
		int[] iArr2 = new int[6];
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}

		iArr2[0] = 999; iArr2[2] = 100;
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		String[] iArr3 = new String[6];
		
		for(int j =0; j < iArr3.length; j++){
		System.out.printf("iArr3[%d] = %d\n", j, iArr3[j]);
		}
		
		int[] iArr4;
		iArr4 = new int[3];
		for(int j = 0; j<iArr4.length; j++) {
			System.out.printf("iArr4[%d] = %d\n", j, iArr4[j]);
		}
		

		
	}
}
