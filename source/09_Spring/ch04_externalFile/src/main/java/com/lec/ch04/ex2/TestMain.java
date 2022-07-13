package com.lec.ch04.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/ex2/applicationCTX.xml");
		AdminInfo info = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println(info);
		ctx.close();
	}
}
