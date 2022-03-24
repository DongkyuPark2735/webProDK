package singleton2;

public class SingletonClass {
	private int i = 10;
//힙메모리에 클래스 담길떄  
	// 이미 객체에 100
	private static SingletonClass INSTANCE; //new객체생성안되면 getINSTANCE

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
