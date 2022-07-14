package com.lec.ch05.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		String location = "classpath:META-INF/applicationCTX2.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		Student2 student = (Student2)ctx.getBean("student2");
		Worker2 worker = (Worker2)ctx.getBean("worker2");
		
		student.getStudentInfo();
		System.out.println();
		worker.getWorkerInfo();
		
	}
}
