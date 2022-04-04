package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");// �ε����� key���� ����
		hashSet.add("str1");// �ϳ��� �����ü� ���� iterator�������

		System.out.println(hashSet);

		hashSet.add("str1");// �ߺ��� �� ����
		System.out.println(hashSet);
		Iterator<String> iterator = hashSet.iterator();// hashSet ��ü�� iterator����

		while (iterator.hasNext()) {
			System.out.println(iterator.next());// str1�� �������� ���� ��ü�� ����Ŵ
		}
	}

}
