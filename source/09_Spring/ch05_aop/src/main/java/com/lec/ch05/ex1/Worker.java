package com.lec.ch05.ex1;

import lombok.Data;

@Data
public class Worker {
	private String name;
	private int age;
	private String job;
	public void getWorkerInfo() {// 호출될 핵심기능(=타겟 메소드 =비즈니스 로직) joinPoint
		System.out.println("이 름 : " + name);
		System.out.println("나 이 : " + age);
		System.out.println("직 업 : " + job);
	}
}
