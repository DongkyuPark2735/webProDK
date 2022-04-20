package singleton1;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class SingletonClass {
	private int i;
	// ��ü���������� �� ��ü�ּҸ� return�ϰ�
	// ��ü������ �������� ��ü�����ϰ� �� �ּҸ� return
	// ��ü�� ��ü������ �ּҸ� �޾ƿ�
	private static SingletonClass INSTANCE = null;
	//private static������ SingletonClass �ڷ��� INSTANCE�̸��� �ν��Ͻ��� ���� 
	public static SingletonClass getInstanec() {
		if(INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	
	private SingletonClass() {
	}

	// �ݵ�� �⺻������ �־����
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}