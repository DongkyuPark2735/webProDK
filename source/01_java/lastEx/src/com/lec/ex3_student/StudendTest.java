package com.lec.ex3_student;

public class StudendTest {

	public static void main(String[] args) {
	StudentDAO test = StudentDAO.getInstance();
	System.out.println(test.getMnameList());
	System.out.println(test.selectSname("박길동"));
	System.out.println(test.selectSname("김길동"));
	
	StudentDAO test2 = StudentDAO.getInstance();
	StudentDTO t1 = test2.selectSno(2022014);
	System.out.println(t1.getMname());
	System.out.println(test2.selectMname("인공지능학"));
	
	//System.out.println(test2.insertStudent(new StudentDTO("황길동", "컴퓨터공학", 50)) == 1? "입력성공" : "입력실패");
//	System.out.println(test2.updateStudent(new StudentDTO(2022019,"황길수","인공지능학",80)) ==1 ?"입력성공" : "입력실패" );
	
	System.out.println(test2.printStudent());
	
	System.out.println(test2.selectMname("인공지능학"));
//	System.out.println(test2.updateStudent(new StudentDTO(2022019,"황길수","인공지능학",80)) ==1 ?"입력성공" : "입력실패" );
	System.out.println(test.updateExpelStudent(2022014)==1? "수정완료"  : "수정실패");
	
	}
	

}
