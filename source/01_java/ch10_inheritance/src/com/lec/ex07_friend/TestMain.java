package com.lec.ex07_friend;

public class TestMain {

	public static void main(String[] args) {
		Friend f1 = new Friend();
		System.out.println(f1.inforString());
		Friend f2 = new Friend("È«±æµ¿");
		System.out.println(f2.inforString());
		Friend f3 = new Friend("È«±æ¼ø", "010-0000-0001");
		System.out.println(f3.inforString());
		
	}

}
