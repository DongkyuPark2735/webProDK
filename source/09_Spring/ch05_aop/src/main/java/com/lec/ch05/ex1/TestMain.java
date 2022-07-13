package com.lec.ch05.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		String location = "classpath:META-INF/applicationCTX1.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		Student student = (Student)ctx.getBean("student");
		Worker worker = (Worker)ctx.getBean("worker");
		
		student.getStudentInfo();
		System.out.println();
		worker.getWorkerInfo();
		
	}
}
