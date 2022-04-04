package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		System.out.println(list.get(0));// list�迭�� collection�� index�� get��

		// k= �ε����� � Ÿ������ ���� // ��ü �ڷ����� �ü�����
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		// Ű //������
		hashMap.put(11, "str11"); // 11key ���� ������ "str11" �߰� //������ ���� Ű���� �ڷ��߰� +
		hashMap.put(new Integer(20), "str20");// 20 key�� ���εǴ� ������ "str20"�߰�
		hashMap.put(33, "str33"); // �����κ��� �߰��ȴ�
		System.out.println(hashMap.get(20));// key������ ������ get��
		System.out.println("remove �� :" + hashMap);
		hashMap.remove(20);// ������ key������
		System.out.println("remove �� :" + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "������ ��� ����" : "������ ����");

		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "�� �����ʹ� " + hashMap.get(key));
		}

	}

}
