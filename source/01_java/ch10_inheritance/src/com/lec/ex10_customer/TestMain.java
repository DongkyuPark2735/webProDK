package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {

		Customer customer = new Customer("ȫ", "010-9999-9999", "����", "1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());

		Person staff = new Staff("��", "010-8888-8888", "2022-09-01", "������");
		// Staff Ÿ�������� personŸ�Ե� �ȴ�?
		Person person = new Person("��", "010-7777-7777");
		Person[] personArr = { customer, staff, person };
		
		System.out.println(staff.infoString());
		
		for (int i = 0; i < personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		//�迭 0~������� infoSting()
		for(Person a : personArr) {
			System.out.println(a.infoString());
		}
		//buy(1000)
		for(Person a : personArr) {
			if(a instanceof Customer) {//p������ Customer�� ��ü�ΰ�?//�ڷ����� �´� �޼��带 �۵��Ҽ��ִ��� Ȯ���ϴ� ��ɾ� 
				((Customer)a).buy(1000);				
			}else {
				System.out.println("buy�� Customer�� �����մϴ�.");
			}
		}
		
	}

}