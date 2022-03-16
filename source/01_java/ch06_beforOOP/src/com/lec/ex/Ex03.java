package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);//다른 클래스 파일 쓸때 import
		Arithmetic ar = new Arithmetic();
		//주소가 저장된 ar이라는 공간만 있음 new선언안했을시
		System.out.println("-7의 절대값은"+ ar.abs(18));
	}
}
