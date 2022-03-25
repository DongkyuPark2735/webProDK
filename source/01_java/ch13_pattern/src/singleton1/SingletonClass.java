package singleton1;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class SingletonClass {
	private int i;
	// 객체생성했으면 그 객체주소를 return하고
	// 객체생성을 안했으면 객체생성하고 이 주소를 return
	// 객체는 객체생성후 주소를 받아옴
	private static SingletonClass INSTANCE = null;
	//private static형식의 SingletonClass 자료형 INSTANCE이름의 인스턴스를 만듬 
	public static SingletonClass getInstanec() {
		if(INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	
	private SingletonClass() {
	}

	// 반드시 기본생성자 있어야함
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
