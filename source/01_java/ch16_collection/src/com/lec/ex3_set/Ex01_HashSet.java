package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");// 인덱스도 key값도 없음
		hashSet.add("str1");// 하나만 가져올수 없음 iterator써ㅑㅇ함

		System.out.println(hashSet);

		hashSet.add("str1");// 중복된 값 못들어감
		System.out.println(hashSet);
		Iterator<String> iterator = hashSet.iterator();// hashSet 객체로 iterator만듬

		while (iterator.hasNext()) {
			System.out.println(iterator.next());// str1을 가져오고 다음 객체를 가르킴
		}
	}

}
