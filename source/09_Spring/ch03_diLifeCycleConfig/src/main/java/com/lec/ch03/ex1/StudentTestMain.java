package com.lec.ch03.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {

	public static void main(String[] args) {
		//classpath 는 리소스폴더 가르킴
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/ex1/applicationCTX1.xml","classpath:META-INF/ex1/applicationCTX2.xml");
		Student student = ctx.getBean("student", Student.class);
		System.out.println("student : " + student);
		
		StudentInfo studentinfo = ctx.getBean("studentinfo", StudentInfo.class);
		System.out.println("studentinfo안의 student : " + studentinfo.getStudent());
		
		if(student.equals(studentinfo.getStudent())) {
			System.out.println("두객체는 같은 객체");
		}
		
		Family family = ctx.getBean("family1", Family.class);
		System.out.println(family);
		ctx.close();
	}
}
