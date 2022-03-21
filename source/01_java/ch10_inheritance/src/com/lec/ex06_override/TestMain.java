package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {

		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass();
		if(pObj1.equals(pObj2)) {
			System.out.println("두 객체는 같다");
		}else {
			System.out.println("두 객체는 다르다");
		}
		
		ChildClass cObj = new ChildClass(2);
		
		if(cObj.equals(pObj1)) {
			System.out.println("무조건 true지");
		}
		pObj1.method1();
		pObj1.method2();
		System.out.println("----------------------------------");
		cObj.method1();//ChildClass의 method1
		cObj.method2();//ParentClass의 method2
		cObj.method3();//ChildClass의 method3
		ParentClass cObj1 = new ChildClass(2);
		//
		cObj1.method1(); //ChildClass의 method1 실행
		cObj1.method2(); //ParentClass의 method1 실행
		//ParentClass형 cObj1변수를 ChildClass형으로 변환가능하니?
		System.out.println();
		if(cObj1 instanceof ChildClass) {//instanceof 좌측 객체가 오른쪽의 클라스 객체인지 
			((ChildClass)cObj1).method3();			//객체의 형변환은  if문으로 물어봐야함
													//컴파일시에 에러가 남
		}else {
			System.out.println("형변환 안 됨");
		}
	}

}
