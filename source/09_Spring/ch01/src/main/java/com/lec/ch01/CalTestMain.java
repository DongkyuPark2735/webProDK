package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {

	public static void main(String[] args) {
		//Calculation cal = new Calculation(1, 2);
//		Calculation cal = new Calculation();
//		cal.setNum1(50);
//		cal.setNum2(10);
		
		// 스프링 컨테이너에 공간 할당  xml을 읽고 xml명령어 수행 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
																			//리소시스 폴더를 classpath라고함. 생략해도됨
		Calculation cal = ctx.getBean("calculation", Calculation.class);
						//name이나 id로 불러옴				class 타입 설정
		cal.add();
		cal.div();
		cal.mul();
		cal.sub();
	
		System.out.println(cal);
		System.out.println(cal.equals(cal));
		ctx.close(); // 

		cal.sub();
		cal.sub();
		
	}
}
