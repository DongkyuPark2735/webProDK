package com.lec.ch02.ex5_exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamTestMain {
	public static void main(String[] args) {
		String loc = "classpath:applicationCTX5.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		ExamConsole console = ctx.getBean("examConsole", ExamConsole.class);
		console.print();
		ctx.close();

	}
}
