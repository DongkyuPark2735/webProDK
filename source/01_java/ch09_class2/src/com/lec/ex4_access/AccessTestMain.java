package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

public class AccessTestMain {
//�����ϱ����� ����������
	//�������� Ŭ���� ������ �ö� 
	//static�� ���������� �ٷ� ���� ������ 
	//static�� ���������� �ش� Ŭ������ ������ �ν���Ʈ���� ������ �ż��尡 ������
	//static���������� ��������ʰ� �޸𸮸� ������ �����ϰ� �ɸ�������?
	
	
    //������ ������ ������ ������ ����Ǹ� �ڹٿ��� ������
	//������?
	//
	public static void main(String[] args) {
//		com.lec.ex3_access.AccessTest obj = new com.lec.ex3_access.AccessTest();
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
//		System.out.println(obj.defaultMember);
//		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();
	}

}
