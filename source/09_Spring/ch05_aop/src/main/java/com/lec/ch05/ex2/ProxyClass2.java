package com.lec.ch05.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//프록시 클래스임을 정의하는 어노테이션 
@Aspect 
public class ProxyClass2 {
	//aroundM이라는 포인트컷
//	@Pointcut("within(com.lec.ch05.ex2.*)")
//	private void aroundM() {}
//	@Around("aroundM()")
	
	//around Advice //뭔가를 수행하고 공통기능 수행하고 다시 ? // 핵심기능 전후로 공통기능 수행
	@Around("within(com.lec.ch05.ex2.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toString(); //핵심기능 메소드명
		System.out.println(signatureName+"가 시작되었습니다.");
		long startTime = System.currentTimeMillis(); // 시작지점
		
		try {
			Object obj = joinPoint.proceed(); // 핵심기능 실행
			return obj; // 핵심기능 수행한 이후의 로직을 finally에 return만나면 바로 종료되기때문
		} finally {
			long endTime = System.currentTimeMillis(); // 핵심기능 수행 후 시점
			System.out.println(signatureName + "가 수행되는 경과시간 : " + (endTime-startTime));
		}
	}	
	
	//before Advice
	@Before("execution(* com.lec.ch05.ex2.Student2.*())")
	public void beforeAdvice() {
		System.out.println("핵심기능 수행하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	//after Advice
	@After("bean(stud*)") // 패키지 내 모든 해당 bean 객체 xml만 ? jsp도? 
	public void afterAdvice() {
		System.out.println("핵심기능 수행하고 알아서 afterAdvice(공통기능) 수행");
	}
	//after-returning Advice
	@AfterReturning("within(com.lec.ch05.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외 발생되지 않고) 핵심기능이 수행된 후 afterReturningAdvice 수행");
	}
	//after-throwing Advice
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능이 수행된 후 afterThrowingAdvice수행");
	}
	
}
