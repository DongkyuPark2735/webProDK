package com.lec.ex1_string;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		// String�� new�� ���������ʰ� " "�� ����� ���ڿ� ����� �̿�, �ڵ������� �������� String��ü�� �̹� �����ϴ��� Ȯ���ϰ� 
		// �̹� �����ϴ� ���ڿ� ��ü�� ����. �������� ������ String ��ü ����  
		String str3 = new String("java");//new �ϸ� ���ο� ����������
		if(str1 ==str2) {
			System.out.println("str1�� str2�� ���� �ּҰ��� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ��� ����");
		}
		if(str1.equals(str2)) {
			System.out.println("���� ���ڿ�");
		}
		
		System.out.println(str3 == str1 ? "str1�� 3������ �ּ� " : "str1�� 3�� �ٸ��ּ�");
		System.out.println(str1.equals(str3)? "���� ��Ʈ��" : "�ٸ� ���ڿ�");
		
	}
}
