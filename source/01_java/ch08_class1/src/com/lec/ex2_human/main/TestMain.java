package com.lec.ex2_human.main;

//다른 패키지 함수 갖다 쓸때 import
//파일명.*는  com.lec.ex2_human.해당 패키지의 하위 모든 class import
import com.lec.ex2_human.*;

//힙이라는 공간에 모든클래스가 올라가면 과부하 위험?
//ctrl shift O = 해당 클래스에서 사용하는 클래스들 자동 import == 사용하지않는 import 삭제
public class TestMain {
	public static void main(String[] args) {

		int i = 10;
		int j = 10;

		if (i == j) {// 기초 데이터 타입에서 같은지 비교
			System.out.println("i와 j는 같다");
		}

		String name = "홍길동";// String은 객체변수 인스턴트 생성해서 써야함
		String name2 = "홍길동";// String은 예외로 ?
		// stack 메모리에 있는지 찾아봄? 같은 주소를 가르킨다

		if (name.equals(name2)) {// 객체변수,참조변수는 비교할떄 equals라는 함수를 쓴다.
			System.out.println("name과 name2는 같다");
		}
		//모든 자바 파일은 기본적으로 Object라는 클래스를 상속받는다
		Woman w1 = new Woman();
		Woman w2 = new Woman();
//		w1.method();
		if (w1.equals(w2)) {
			System.out.println("w1과 w2는 같다.");
		}
		
		Man kang = new Man(22, 165, 60.2);
		Man kim = new Man(22, 180, 65.6); 
		Man kim1;//레퍼런스 변수(객체변수)선언
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);// kim과 매개변수와 수치가 같지만 new로인해 
										  // 다른 주소로 할당된 상태이기 때문에 다르다 
		if(kim.equals(kim1)) {
			System.out.println("kim과 kim1은 같다.(같은 주소를 가르킨다)");
		}
		if(!kim.equals(kim2)) {// ! 부정문  !레퍼런스.equals형식
			System.out.println("kim과 kim2는 다르다.(다른 주소값이 있다.)");				
		}
		kang.setHeight(160);
		kang.setWeight(51);//묵시적 형변환 가능 = 데이터 작은값이 큰값으로갈떄
		if(kang.calculateBMI() > 30) {
			System.out.println("건강하세요");
		}else {
			System.out.println("건강하겠네요");
		}
		
     }
}
