//패키지명, 클래스명, 데이터, 생성자 함수(오버로딩), 매소드, set , get
package com.lec.ex1_square;

public class Square {
	private int side;
	//생성자 함수 자체가 없을때는 JVM에서 컴파일 단계에서 디폴트 생성자(아무것도 하지않는 매개변수 없는) 자동 생성
	//매개 변수 있는 생성자 만들떄 매개변수 없는디폴트 생성자 생성해야함
	public Square() {//생성자 함수 : return 타입이 없고 , 클래스 명과 같은 함수
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}//생성자함수는 클라스랑 이름 같은 함수
	public Square(int side) {// 매개변수 있는 생성자 함수 용도 : 데이터 초기화
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출. side 초기화");
	}
	public int area() {
		return side * side;
	}
	//setter & getter

	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
	
}