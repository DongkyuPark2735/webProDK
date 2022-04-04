package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		String[] array = new String[4];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str3";// 중간에 건너뛰어도 상관없음 셋팅을 미리함

		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d] = %s\n", i, array[i]);
		}
		System.out.println();
		for (String i : array) {
			System.out.printf(i + "\n");
		}

		System.out.println("\n ~~~~~~~ArrayList~~~~~~~");

		ArrayList<String> arrayList = new ArrayList<String>(); // <>에 자료형 // String 형 Arraylist객체 생성
		// 빈 객체에서 생성할때마다 명시한 자료형의 객체 추가 생성 //ArrayList는 int형 안됨 기초데이터타입 안됨 //object타입이
		// 들어와야함 객체자료형 들어가야함 //객체로 생성
		arrayList.add("str0"); // 0번 인덱스 생성 중간에 추가하면 하나씩 밀림
		arrayList.add("str1"); // 1번 인덱스 생성 -> 2번 인덱스
		arrayList.add("str2"); // 2번 인덱스 생성 -> 3번 인덱스
		System.out.println(arrayList.get(0));

		arrayList.add(1, "str111111111"); // 1번 인덱스에 추가 ;
		System.out.println(arrayList.toString());

		arrayList.set(1, "11111");
		System.out.println(arrayList);

		for (String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove한 후에 -");
		arrayList.remove(1);// 1번째 인덱스의 데이터 삭제 // 중간에 삭제하면 들여쓰기됨 (2->1번 인덱스, 3->2번 인덱스)
//		arrayList.remove("11111");//데이터를 명시해서 삭제 가능 //중복된 데이터 하나만 삭제가능 
		arrayList.remove(arrayList.size() - 1);// 맨 마지막 인덱스 삭제

		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.printf("%d번째 인덱스 값은 %s\t", idx, arrayList.get(idx));
		}

		System.out.println();
		arrayList.clear(); // arrayList의 안의 모든 데이터 삭제
		if (arrayList.size() == 0) {
			System.out.println("arrayList의 데이터는 없습니다.");
		}
		if (arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다.");
		}
		System.out.println(arrayList);
		arrayList = null;// arrayList 객체 삭제 
//		System.out.println(arrayList.size());
		
		
	}
}
