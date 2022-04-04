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
		while (iterator1.hasNext()) {// 순서가 없는 객체 출력
			System.out.println(iterator1.next());
		}
		//list계열은 iterator를 잘 사용하지 않는다. 배열이 있기때문 
		//list계열은 for문을 주로 쓴다 .
		for (String l : list) {
			System.out.println(l);
		}
		// 맵
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("홍길동", "010-9999-9999");
		map.put("김길동", "010-9999-9999");//객체 출력할때 순서 상ㅇ관없을 때 iterator
		Iterator<String>iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " 키의 데이터 : "+ map.get(key));
			
			
//			System.out.println(iterator2.next() + " 키의 데이터 " + map.get(iterator2.next()));// next한번더하면 다음데이터
									//홍길동							//김길동 //get은 key의 데이터 가져오는 함수 
		}
		
		//셋
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
