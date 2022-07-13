package com.lec.ch04.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 생성
		ConfigurableEnvironment env = ctx.getEnvironment(); // 컨테이너의 환경변수 가져옴
		MutablePropertySources propertySource = env.getPropertySources(); //env의 속성과 속성값 set 
		
		try {
				//외부설정 파일을 evo안의 properetySource에 추가
			propertySource.addLast(new ResourcePropertySource("classpath:META-INF/ex1/admin.properties"));// 맨뒤에 속성 추가
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id =" + env.getProperty("admin.id"));//env.getProperty("admin.id") 속성값 가져옴 
		System.out.println("admin.pw =" + env.getProperty("admin.pw"));
		
		
		// env에 외부 설정파일 속성들을 추가한 후 빈 생성
		ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh();
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("adminId : "+admin.getAdminId());
		System.out.println("adminPw : "+admin.getAdminPw());
		ctx.close();
		
	}
}
