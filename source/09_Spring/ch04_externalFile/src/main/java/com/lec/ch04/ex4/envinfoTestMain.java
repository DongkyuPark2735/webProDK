package com.lec.ch04.ex4;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class envinfoTestMain {
	public static void main(String[] args) {
		String config = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("dev? run?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("잘못된 경로입력");
		}
		
		sc.close();

		String location1 = "classpath:META-INF/ex4/dev.xml";
		String location2 = "classpath:META-INF/ex4/run.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	
		ctx.getEnvironment().setActiveProfiles(config);
//		cev.setActiveProfiles(config);
		ctx.load(location1, location2);
		ctx.refresh();
		
		EnvInfo ev = ctx.getBean("envInfo", EnvInfo.class);
		
		System.out.println("ipNum : " + ev.getIpNum());
		System.out.println("portNum : " + ev.getPortNum());
		System.out.println("userId : " + ev.getUserId());
		System.out.println("pw : " + ev.getUserPw());
		
	}
}
