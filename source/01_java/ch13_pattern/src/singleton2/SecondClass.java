package singleton2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance(); //new��ü �����Ҽ������ϱ� get
		System.out.println("SecondClass ������ ������");
		System.out.println("�̱��� ��ü�� i�� :" + singletonObject.getI());
		System.out.println("SecondClass ������ ��");
	}

}
