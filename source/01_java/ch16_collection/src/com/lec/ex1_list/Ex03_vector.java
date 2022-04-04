package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<>();
//		vec.add(new Integer(10));
		vec.add(10);
		vec.add(new AClass());
		BClass objB = new BClass();
		vec.add(objB);

		System.out.println(vec);
		for (Object obj : vec) {
			System.out.println(obj);// vector는 toString오버리이드 해야함
		}
		for (int idx = 0; idx < vec.size(); idx++) {
			System.out.println(vec.get(idx));
		}

	}
}
