package com.lec.ch03.ex3;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex1.Family;

public class SingletonTestMain {

	public static void main(String[] args) {
		String loc = "classpath:META-INF/ex3/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(loc);
		
		Family family1 = (Family)ctx.getBean("family");
		Family family2 = ctx.getBean("family", Family.class);
		family1.setPapaName("박아빠"); 
		family1.setMamiName("박엄마");
		System.out.println("family1 : " + family1);
		System.out.println("family2 : " + family2);
		System.out.println("===========================");
		
		Family family3 = ctx.getBean("familyPrototype", Family.class);
		Family family4 = ctx.getBean("familyPrototype", Family.class);
		family3.setPapaName("집나간 아빠"); 
		family3.setMamiName("집나간 엄마");
		System.out.println("family3 : " + family3);
		System.out.println("family4 : " + family4);
		
		
	}
}
