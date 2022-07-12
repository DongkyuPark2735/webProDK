package com.lec.ch02.ex3_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {

	public static void main(String[] args) {
		String conf = "classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		StudentInfo stif = ctx.getBean("studentInfo" ,StudentInfo.class);
		stif.getInfo();
		
		Student st = ctx.getBean("student1", Student.class);
		if(st.equals(stif.getStudent()));{
			System.out.println("두 객체는 같다");
		}

		Student st2 = ctx.getBean("student2", Student.class);
		stif.setStudent(st2);
		stif.getInfo();
		
		ctx.close();
		
		
	}
}
