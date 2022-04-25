package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("김길순",60,80,70,"배우");
		int result = dao.insertPerson(dto);// 입력 test
		System.out.println(result == PersonDao.SUCCESS? "입력성공" : "입력실패");
		ArrayList<PersonDto> dtos = dao.selectJname("배우"); //직업별 조회 test
		if(dtos.isEmpty()) {
			System.out.println("해당 직업의 사람이 등록되지 않았습니다.");
		}else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		}
		dtos = dao.selectALL(); // 전체조회
		if(dtos.size() != 0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("등록된 사람이 없습니다.");
		}
		Vector<String> jnames = dao.jnamelist();//직업명 리스트 tst
		System.out.println(jnames);
		
	}
}
