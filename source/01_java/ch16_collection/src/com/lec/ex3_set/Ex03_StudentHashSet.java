package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6, "�̼���");
		students.add(s);//��ü �ٷ� �Է�
		students.add(s);//�ؽ��ڵ� ���Ƽ� �ߺ����� �ȵ餷� 
//		System.out.println(students);
		students.add(new Student(3,"ȫ�浿"));//�ٸ� ��ü�� �ν��� 
		students.add(new Student(3,"ȫ�浿"));//���� �̸��̾ �ؽ��ڵ尡 �޶� �ߺ����� ��  
		students.add(new Student(6,"�̼���"));//��ü
		
		System.out.println(students);
		
		
	}
}
