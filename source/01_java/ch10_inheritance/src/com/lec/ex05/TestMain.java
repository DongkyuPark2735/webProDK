package com.lec.ex05;

//		Super
//Child 1     Child2
//GrandChild
public class TestMain {
	public static void main(String[] args) {
		Super s = new Super();
		System.out.println(s.s);
		Child1 c1 = new Child1();
		System.out.println("c1.s=" + c1.s + " c1.c1=" + c1.c1);
		Child2 c2 = new Child2();
		System.out.println("c2.s=" + c2.s + " c2.c2=" + c2.c2);
//		System.out.println("c2.c1=" + c2.c1); 불가능
		GrandChild g1 = new GrandChild(100);
		System.out.println("g1.s=" + g1.s + " g1.c1=" + g1.c1 + " g1.gc=" + g1.gc);
//		System.out.println("g1.c2=" + g1.c2); 불가능

	}
}
