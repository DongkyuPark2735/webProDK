package singleton2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance(); //new객체 생성할수없으니까 get
		System.out.println("SecondClass 생성자 실행중");
		System.out.println("싱글톤 객체의 i값 :" + singletonObject.getI());
		System.out.println("SecondClass 생성자 끝");
	}

}
