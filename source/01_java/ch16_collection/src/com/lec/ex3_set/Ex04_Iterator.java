package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR");
		list.add("STR");
		System.out.println(list);
		Iterator<String> iterator1 = list.iterator();
		while (iterator1.hasNext()) {// ������ ���� ��ü ���
			System.out.println(iterator1.next());
		}
		//list�迭�� iterator�� �� ������� �ʴ´�. �迭�� �ֱ⶧�� 
		//list�迭�� for���� �ַ� ���� .
		for (String l : list) {
			System.out.println(l);
		}
		// ��
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ȫ�浿", "010-9999-9999");
		map.put("��浿", "010-9999-9999");//��ü ����Ҷ� ���� �󤷰����� �� iterator
		Iterator<String>iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " Ű�� ������ : "+ map.get(key));
			
			
//			System.out.println(iterator2.next() + " Ű�� ������ " + map.get(iterator2.next()));// next�ѹ����ϸ� ����������
									//ȫ�浿							//��浿 //get�� key�� ������ �������� �Լ� 
		}
		
		//��
		HashSet<String> set = new HashSet<String>();
		set.add("str0");
		set.add("str1");
		set.add("str1");
		Iterator<String> iterator3 = set.iterator(); 
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
		

	}

}
