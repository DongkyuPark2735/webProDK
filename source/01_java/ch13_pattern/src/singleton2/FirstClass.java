package singleton2;


public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();//��ü�� ��������ʰ� //
		System.out.println("�̱��� ��ü�� i�� :" + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("�̱��� ��ü�� i�� ������" + singletonObject.getI());
		
	}
}
