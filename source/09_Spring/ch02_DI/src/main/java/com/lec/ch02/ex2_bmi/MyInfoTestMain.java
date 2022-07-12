package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTestMain {
	public static void main(String[] args) {
		String res = "classpath:applicationCTX2.xml";
		//웹에서는 안씀
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(res);
			
	//	MyInfo myibfo = (MyInfo)ctx.getBean("myInfo");
		MyInfo myibfo = ctx.getBean("myInfo", MyInfo.class);
		myibfo.getInfo();
		ctx.close();
		
		
	}
}
