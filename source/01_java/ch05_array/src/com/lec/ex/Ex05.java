package com.lec.ex;

import java.util.Scanner;

//5���� �л����� Ű�� �޾� ���Ű�� ���
//����� ģ�� �̸��� Ű, �ִܽ� ģ�� �̸��� Ű ���
//�迭�� Ư�������� �ִ� ���� ������ �����ص� �ν���Ʈ �ʿ�����?
//���� ���� ���� �� ��ȯ ����
 public class Ex05 {
	public static void main(String[] args) {
		String[] arrName = { "����", "ö��", "�浿", "����", "����" };
		int[] arrHeight = new int[arrName.length];
		
		Scanner s1 = new Scanner(System.in);
		int totalHeight = 0;
		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i]+"�� Ű��:");
			arrHeight[i] = s1.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("���Ű�� " + totalHeight/(double)arrName.length);
		
	}
}
