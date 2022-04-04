package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		System.out.println(list.get(0));// list계열의 collection은 index로 get함

		// k= 인덱스가 어떤 타입인지 설정 // 객체 자료형만 올수있음
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		// 키 //데이터
		hashMap.put(11, "str11"); // 11key 값에 데이터 "str11" 추가 //순서가 없고 키값에 자료추가 +
		hashMap.put(new Integer(20), "str20");// 20 key에 매핑되는 데이터 "str20"추가
		hashMap.put(33, "str33"); // 앞으로부터 추가된다
		System.out.println(hashMap.get(20));// key값으로 데이터 get함
		System.out.println("remove 전 :" + hashMap);
		hashMap.remove(20);// 삭제는 key값으로
		System.out.println("remove 후 :" + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 모두 삭제" : "데이터 있음");

		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는 " + hashMap.get(key));
		}

	}

}
