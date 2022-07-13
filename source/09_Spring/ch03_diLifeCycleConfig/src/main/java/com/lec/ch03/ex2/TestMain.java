package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		String resouce = "classpath:META-INF/ex2/applicationCTX1.xml";
		
		// ioc컨테이너 생성(환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// 파싱
		ctx.load(resouce);
		ctx.refresh(); // 빈 생성 
		System.out.println("----------------------------------");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson oterperson = ctx.getBean("otherPerson", OtherPerson.class);
		System.out.println(oterperson);
		System.out.println("-----------------------------------");
		ctx.close();
		System.out.println("빈 소멸");
		
	}
}
