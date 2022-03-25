package com.lec.ex1_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "       ja            va       ";
		System.out.println("1."+str1.concat(str2)); //abcXabcABCXabc String�ΰ� ���ϱ�
		System.out.println("2."+str1.substring(3));// Xabc 3��° ���ں���
		System.out.println("3."+str1.substring(3,5));//Xa 3��° ���ں��� 5��° �ձ���
		System.out.println("4."+str1.length());// 7 ����
		System.out.println("5."+str1.toUpperCase());// ABCXABC �빮�ڷ� �빮�ڴ� �״�ε� 
		System.out.println("6."+str1.toLowerCase());// abcxabc �ҹ��ڷ� �ҹ��ڴ� �״�ε�
		System.out.println("7."+str1.charAt(3));// 3��° ���� ��� 'x'
		System.out.println("8."+str1.indexOf('b'));//ù��°'b'�� ������ �ε��� 1
		System.out.println("9."+str1.indexOf('b', 3));//3��° ���� b�� ��𳪿����� �˻��ؼ� ù��° 'b'��ġ 
		System.out.println("10."+str1.indexOf("abc")); //ù��° "abc"������ ��ġ
		System.out.println("11."+str1.indexOf("abc" , 3)); //3��° "abc"������ ��ġ ������ -1
		System.out.println("12."+str1.indexOf('z')); //������ -1
		System.out.println("13."+str1.lastIndexOf('b')); //������ 'b'��ġ 4 
		System.out.println("14."+str1.lastIndexOf('b', 3)); //������ 'b' 3��° ���� ������
		System.out.println("15."+str1.equals(str2)); //str1�� str2�� ���� ���ڿ����� false 
		System.out.println("16."+str1.equalsIgnoreCase(str2)); //str1�� str2�� ���� ���ڿ����� ��ҹ��� ���о��� true 
		System.out.println("17."+str3.trim()); //�յڰ��� ����  ja       va
		System.out.println("18."+str1.replace('a', '9')); // 'a'�� '9'�� ���� 9bcX9bc
		System.out.println("19."+str1.replace("ab", "��")); // ���ڿ��� ���� 19.��X��
		System.out.println("20."+str3.replace(" ", "")); // �����̽� ��ĭ�� ���ڿ��� 
		System.out.println("21."+str1.replaceAll("abc", "Z")); // "abc"�� "Z"�� 
//		System.out.println("21."+str1.replaceAll); // "abc"�� "Z"�� 
								//����ǥ���� ?
		String str = "�ȳ�Hello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));//���ĺ��� ""�� ���� 
		//���� ��ü�� �����ϴ°� �ƴ϶� Ư���� �Է½��� �ִ�. 
		String i;
		System.out.println(str.replaceAll("[��-�R]", ""));//�ѱ۹��ڸ� ""�� ����
		//���ڿ� �żҵ�� ���ڿ��� ��������
		System.out.println(str1+str2+str);
	}
}
