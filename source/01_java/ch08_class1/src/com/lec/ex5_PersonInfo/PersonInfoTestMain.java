package com.lec.ex5_PersonInfo;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo park = new PersonInfo("동규", 32, "남성");
		PersonInfo park2 = new PersonInfo();
		park2.setName("준현");
		park2.setAge(30);
		park2.setGender("남성");
		park.print();
		park2.print();

		PersonInfo jung = new PersonInfo("아현", 27, "여성");
		PersonInfo jung2 = new PersonInfo();
		jung2.setName("효원");
		jung2.setAge(31);
		jung2.setGender("남성");
		jung.print();
		jung2.print();
		
//		int[] arr = { 1, 2 };
		
		PersonInfo[] person = { park, park2 };

		for(int idx = 0; idx<person.length; idx++) {
			person[idx].print();
		}
		for(PersonInfo p : person ) {
			p.print();
		}
// 		PersonInfo[] person = {new PersonInfo(),
//								new PersonInfo()};
	}

}
