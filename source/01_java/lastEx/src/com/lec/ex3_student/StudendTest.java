package com.lec.ex3_student;

public class StudendTest {

	public static void main(String[] args) {
	StudentDAO test = StudentDAO.getInstance();
	System.out.println(test.getMnameList());
	System.out.println(test.selectSname("�ڱ浿"));
	System.out.println(test.selectSname("��浿"));
	
	StudentDAO test2 = StudentDAO.getInstance();
	StudentDTO t1 = test2.selectSno(2022014);
	System.out.println(t1.getMname());
	System.out.println(test2.selectMname("�ΰ�������"));
	
	//System.out.println(test2.insertStudent(new StudentDTO("Ȳ�浿", "��ǻ�Ͱ���", 50)) == 1? "�Է¼���" : "�Է½���");
//	System.out.println(test2.updateStudent(new StudentDTO(2022019,"Ȳ���","�ΰ�������",80)) ==1 ?"�Է¼���" : "�Է½���" );
	
	System.out.println(test2.printStudent());
	
	System.out.println(test2.selectMname("�ΰ�������"));
//	System.out.println(test2.updateStudent(new StudentDTO(2022019,"Ȳ���","�ΰ�������",80)) ==1 ?"�Է¼���" : "�Է½���" );
	System.out.println(test.updateExpelStudent(2022014)==1? "�����Ϸ�"  : "��������");
	
	}
	

}
