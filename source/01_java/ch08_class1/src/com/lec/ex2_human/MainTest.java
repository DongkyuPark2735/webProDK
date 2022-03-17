package com.lec.ex2_human;

public class MainTest {
	public static void main(String[] args) {
		Man m1 = new Man();
		Man m2 = new Man(22, 170, 68, "010-3333-3333");
		Man m3 = new Man(22, 170, 68);
		Man yi = new Man(22); 
		Man w1 = new Man();
		Man w2 = new Man();
		
		System.out.println(w1.getClass().getName());
   }
}