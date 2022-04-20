package singleton2;

public class SingletonClass {
	private int i = 10;
//���޸𸮿� Ŭ���� ��拚  
	// �̹� ��ü�� 100
	private static SingletonClass INSTANCE; //new��ü�����ȵǸ� getINSTANCE

//	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}

	private SingletonClass() {
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}