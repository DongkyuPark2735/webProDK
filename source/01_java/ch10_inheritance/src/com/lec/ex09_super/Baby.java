package com.lec.ex09_super;
//name, character / intro()
//Baby b = new Baby("ȫ�ư�", "�̻�"); 
//Baby b1 = new Baby(); 
public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű����� ���� Baby ������");
	}//�Ű����� ���� ������ �����Ҷ� �θ�Ŭ���� �Ű����� ���°� ������
	public Baby(String name, String character) {
//		setName(name);
//		setCharacter(character);
		super(name, character);//�Ű����� �ִ°��� ������ָ� �Ű����� ���� �����ڰ� ������ �ȵ�
		System.out.println("�Ű����� �ִ� Baby ������");//�������� �θ�Ŭ���� �����ƴ�?
	}
	public void intro() {
		System.out.println("�� �ư���");
		super.intro();//�� Ŭ������ ���۴��� intro()
	}
	
	
}

