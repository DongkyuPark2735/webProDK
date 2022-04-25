package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("����",60,80,70,"���");
		int result = dao.insertPerson(dto);// �Է� test
		System.out.println(result == PersonDao.SUCCESS? "�Է¼���" : "�Է½���");
		ArrayList<PersonDto> dtos = dao.selectJname("���"); //������ ��ȸ test
		if(dtos.isEmpty()) {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�.");
		}else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		}
		dtos = dao.selectALL(); // ��ü��ȸ
		if(dtos.size() != 0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}
		Vector<String> jnames = dao.jnamelist();//������ ����Ʈ tst
		System.out.println(jnames);
		
	}
}
