package com.lec.ex;

import java.util.Scanner;

//����� �ִܽ� 
public class Ex05_minMax {
	public static void main(String[] args) {
		String[] arrName = { "����", "ö��", "�浿", "����", "����" };
		int[] arrHeight = new int[arrName.length];

		Scanner s1 = new Scanner(System.in);
		int totalHeight = 0;
		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i] + "�� Ű��:");
			arrHeight[i] = s1.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("���Ű�� " + totalHeight / (double) arrName.length);
		s1.close();

		int minHeight = 200, minIdx = 0;
		int maxHeight = 0, maxIdx = 0;

		for (int i = 0; i < arrName.length; i++) {
			if (arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			}
			if (arrHeight[i] > maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if������ ������ �߻��Ҽ� ������ �ڹٰ� �Ǵ� ������ ������ ��?
		}
		System.out.printf("����� �л��� %s, Ű�� %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("�ִܽ� �л��� %s, Ű�� %d\n", arrName[minIdx], minHeight);

	}
}
