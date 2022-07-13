package com.lec.ch04.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ServerTestMain {
	public static void main(String[] args) {
		String config = null;
		String location1 = "classpath:META-INF/ex3/CTX_dev.xml";
		String location2 = "classpath:META-INF/ex3/CTX_run.xml";
		Scanner sc = new Scanner(System.in);
		System.out.println("dev중? run중?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.exit(0);
		}
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 매개변수로 넎으면 바로 파싱?
		
		ctx.getEnvironment().setActiveProfiles(config); // 해당 Profiles를 활성화 언제 xml실행시 ?  파싱을 해당 config만? 
		
		ctx.load(location1, location2);
		ctx.refresh(); //안해도됨???
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		
	}
}




