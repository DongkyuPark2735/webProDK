package com.lec.method;
//public ���� ���    sum/evenOdd(static) vs abs(�Ϲ�)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);//���������� �Ⱦ��� ������Ű�������� ���
			System.out.println("1~10���� ���� " + tot);//static �Լ��� Ŭ���� �� 
			System.out.println(Arithmetic.evenOdd(tot));
			Arithmetic ar = new Arithmetic();
			System.out.println(ar.abs(-8));//
	}//Ŭ������ ��üȭ �ν��Ͻ�ȭ  ���ظ޸𸮿� �ø����� new������
	//�빮�ڷ� �����ϴ� �� new�����ڷ�
	//static�� ���� �ż���� �ν���Ʈ(��ü) ���� ���
	//�ν���Ʈȭ �ϴ°��� ����Ҽ��ְ� ���ظ޸𸮿� �ø��°�?
}
