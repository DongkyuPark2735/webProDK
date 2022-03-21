package com.lec.ex06_override;

//ParentClass의 method1(), method2()상속받음
public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("매개변수 없는 ChildClass 생성자");
	}

	public ChildClass(int i) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}

	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}

	public void method1() {//ParentClass의 Method1오버라이드
		//오버라이드 접근제한자는 커지거나 같아야함
		System.out.println("ChildClass의 method1() 함수");
	}
	public boolean equals(Object obj) {//Object 클래스의 equals 오버라이드
		return true;
		
	}
}
