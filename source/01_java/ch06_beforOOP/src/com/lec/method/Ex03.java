package com.lec.method;
//public 변수 사용    sum/evenOdd(static) vs abs(일반)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);//접근제어자 안쓰면 같은패키지에서만 사용
			System.out.println("1~10까지 합은 " + tot);//static 함수는 클래스 내 
			System.out.println(Arithmetic.evenOdd(tot));
			Arithmetic ar = new Arithmetic();
			System.out.println(ar.abs(-8));//
	}//클래스를 객체화 인스턴스화  스텍메모리에 올리려면 new연산자
	//대문자로 시작하는 것 new연산자로
	//static이 없는 매서드는 인스턴트(객체) 만들어서 사용
	//인스턴트화 하는것은 사용할수있게 스텍메모리에 올리는것?
}
