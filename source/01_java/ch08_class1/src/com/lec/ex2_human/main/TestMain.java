package com.lec.ex2_human.main;

//�ٸ� ��Ű�� �Լ� ���� ���� import
//���ϸ�.*��  com.lec.ex2_human.�ش� ��Ű���� ���� ��� class import
import com.lec.ex2_human.*;

//���̶�� ������ ���Ŭ������ �ö󰡸� ������ ����?
//ctrl shift O = �ش� Ŭ�������� ����ϴ� Ŭ������ �ڵ� import == ��������ʴ� import ����
public class TestMain {
	public static void main(String[] args) {

		int i = 10;
		int j = 10;

		if (i == j) {// ���� ������ Ÿ�Կ��� ������ ��
			System.out.println("i�� j�� ����");
		}

		String name = "ȫ�浿";// String�� ��ü���� �ν���Ʈ �����ؼ� �����
		String name2 = "ȫ�浿";// String�� ���ܷ� ?
		// stack �޸𸮿� �ִ��� ã�ƺ�? ���� �ּҸ� ����Ų��

		if (name.equals(name2)) {// ��ü����,���������� ���ҋ� equals��� �Լ��� ����.
			System.out.println("name�� name2�� ����");
		}
		//��� �ڹ� ������ �⺻������ Object��� Ŭ������ ��ӹ޴´�
		Woman w1 = new Woman();
		Woman w2 = new Woman();
//		w1.method();
		if (w1.equals(w2)) {
			System.out.println("w1�� w2�� ����.");
		}
		
		Man kang = new Man(22, 165, 60.2);
		Man kim = new Man(22, 180, 65.6); 
		Man kim1;//���۷��� ����(��ü����)����
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);// kim�� �Ű������� ��ġ�� ������ new������ 
										  // �ٸ� �ּҷ� �Ҵ�� �����̱� ������ �ٸ��� 
		if(kim.equals(kim1)) {
			System.out.println("kim�� kim1�� ����.(���� �ּҸ� ����Ų��)");
		}
		if(!kim.equals(kim2)) {// ! ������  !���۷���.equals����
			System.out.println("kim�� kim2�� �ٸ���.(�ٸ� �ּҰ��� �ִ�.)");				
		}
		kang.setHeight(160);
		kang.setWeight(51);//������ ����ȯ ���� = ������ �������� ū�����ΰ���
		if(kang.calculateBMI() > 30) {
			System.out.println("�ǰ��ϼ���");
		}else {
			System.out.println("�ǰ��ϰڳ׿�");
		}
		
     }
}
