package com.lec.ex10_customer;

//address, sum, point, date, vip 
//Customer c = new Customer("ȫ", "010", "��", "1995-12-12"
public class Customer extends Person {
	private String address;
	private int sum;// ���� �����ݾ�
	private int point;// ����Ʈ(���Ÿ��� 5%����)
	private String date;// �����(dateŸ�� �� ����)
	private boolean vip;// true�� vip fales�� �Ϲ�

	public Customer(String name, String tel, String address, String date) {
		super(name, tel);// �ݵ�� ù��° ���ο� �;���
		this.address = address;
		this.date = date;
		point = 1000;// �� ������ 1000����Ʈ �ڵ��ο�
		System.out.println(name + "�� ��ϵǾ����ϴ�. ����Ʈ 1000���� �����ε帳�ϴ�.");
	}

	public void buy(int price) {// c.buy(10000);
		sum += price;
		int tempPoint = (int) (price * 0.05);// ��ü ��ȣ �� �տ� ���ڷ��� �ڷ������� �ϸ� ��ȣ���� ����
		point += tempPoint;
		System.out.println(getName() + "�� �����մϴ�. �ݹ� ����Ʈ :" + tempPoint + "�� �߰��Ǿ� �� ����Ʈ :" + point);
		if (sum >= 1000000 && vip == false) {
			vip = true;//���� ���������� 100���� �̻�� vip������
			System.out.println(getName()+"�� vip������ ���׷��̵� �Ǽ̽��ϴ�.");
		}
	}	
	@Override //�������̵� Ȯ��  @:������̼� ,���������ʰ� ��ǻ�Ϳ��� �˷��� , �ش����� ����x
	public String infoString() {
		return super.infoString() + "[�ּ�]" +address+"[����Ʈ]"+point+"[�����ݾ�]"+sum;
	}

}
