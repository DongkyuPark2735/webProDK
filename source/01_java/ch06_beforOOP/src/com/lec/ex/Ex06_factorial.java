package com.lec.ex;

import java.util.Scanner;

//����ڷκ��� ���� �Է¹޾� �Է¹��� �� !=       0! =1 
public class Ex06_factorial {
	public static void main(String[] args) {
		int su;
		Scanner sc1 = new Scanner(System.in);
		do {
			System.out.println("����� �Է��ϼ��� :");
			su = sc1.nextInt();
		} while (su <= 0);

		long result = factorial(su);
		System.out.println("�Է��Ͻ�" + su + "! =" + result);
		System.out.printf("�Է��Ͻ� %d != %d", su, result);

	}

	private static long factorial(int su1) {// su�� 1�ʰ��ϰ��: su * factorial(su-1)
		if (su1 == 1) {
			return 1;//��� �����ϰ� �ٽ� ȣ���� ������ ���ϰ� //��������� �Լ�ȣ��
		}else {
			return su1 * factorial(su1-1);//�Լ� �ȿ� �Լ� ȣ��
		}

	}
//	private static long factorial(int su1) {
//		int result = 1;
//		for(int i =su1; i >=1; i--) {
//			result *= i;
//		}
//			
//		return result;
//	}

}
