package com.lec.ex;

//println() ; �ܼ�â�� ���(��������)
//print() ; �ܼ�â�� ���(���������)
//printf() ; �ܼ�â�� Ư�� �������� ���(���������)
public class VarEx02 {
	public static void main(String[] args) {
		int i = 10; // 4����Ʈ
		byte j = 10; // 2����Ʈ
		double h = 10.15;
		i = 5;
		char c1 = 'A';
		char c2 = 'B';

		System.out.println("i=" + i + "\t j=" + j + "\t h=" + h);
		System.out.print("c1=" + c1 + "\t c2=" + c2 + "\n"); // t�� �� n�� �ٳѱ��
		System.out.printf("c1=%c \t c2=%c \n", c1, c2);// %c= ���� %d= ���� %f= �Ǽ� %s= ���ڿ�
		System.out.printf("i=%d, j=%d, h=%5.1f \n", i, j, h);
		System.out.println("��");
	}
}
