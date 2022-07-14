package com.lec.ch05.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Testmain2 {

	public static void main(String[] args) {

	String location = "classpath:META-INF/applicationCTX1.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		Student2 student = (Student2)ctx.getBean("student");
		
		student.getStudentInfo();
	}

}
