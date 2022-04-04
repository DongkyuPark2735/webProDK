package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		String[] array = new String[4];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str3";// �߰��� �ǳʶپ ������� ������ �̸���

		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d] = %s\n", i, array[i]);
		}
		System.out.println();
		for (String i : array) {
			System.out.printf(i + "\n");
		}

		System.out.println("\n ~~~~~~~ArrayList~~~~~~~");

		ArrayList<String> arrayList = new ArrayList<String>(); // <>�� �ڷ��� // String �� Arraylist��ü ����
		// �� ��ü���� �����Ҷ����� ����� �ڷ����� ��ü �߰� ���� //ArrayList�� int�� �ȵ� ���ʵ�����Ÿ�� �ȵ� //objectŸ����
		// ���;��� ��ü�ڷ��� ������ //��ü�� ����
		arrayList.add("str0"); // 0�� �ε��� ���� �߰��� �߰��ϸ� �ϳ��� �и�
		arrayList.add("str1"); // 1�� �ε��� ���� -> 2�� �ε���
		arrayList.add("str2"); // 2�� �ε��� ���� -> 3�� �ε���
		System.out.println(arrayList.get(0));

		arrayList.add(1, "str111111111"); // 1�� �ε����� �߰� ;
		System.out.println(arrayList.toString());

		arrayList.set(1, "11111");
		System.out.println(arrayList);

		for (String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� -");
		arrayList.remove(1);// 1��° �ε����� ������ ���� // �߰��� �����ϸ� �鿩����� (2->1�� �ε���, 3->2�� �ε���)
//		arrayList.remove("11111");//�����͸� ����ؼ� ���� ���� //�ߺ��� ������ �ϳ��� �������� 
		arrayList.remove(arrayList.size() - 1);// �� ������ �ε��� ����

		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.printf("%d��° �ε��� ���� %s\t", idx, arrayList.get(idx));
		}

		System.out.println();
		arrayList.clear(); // arrayList�� ���� ��� ������ ����
		if (arrayList.size() == 0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		if (arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		System.out.println(arrayList);
		arrayList = null;// arrayList ��ü ���� 
//		System.out.println(arrayList.size());
		
		
	}
}
