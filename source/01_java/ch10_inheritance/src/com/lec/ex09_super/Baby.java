package com.lec.ex09_super;
//name, character / intro()
//Baby b = new Baby("홍아가", "이뻐"); 
//Baby b1 = new Baby(); 
public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}//매개변수 없는 생성자 실행할때 부모클래스 매개변수 없는거 생성됨
	public Baby(String name, String character) {
//		setName(name);
//		setCharacter(character);
		super(name, character);//매개변수 있는것을 명시해주면 매개변수 없는 생성자가 실행이 안됨
		System.out.println("매개변수 있는 Baby 생성자");//생성순서 부모클래스 먼저아님?
	}
	public void intro() {
		System.out.println("난 아가야");
		super.intro();//내 클래스의 슈퍼단의 intro()
	}
	
	
}

