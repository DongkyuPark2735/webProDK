package com.lec.ex;

// class : ������(�Ӽ�, �ν���Ʈ����) �� �޼ҵ�(���, setter, getter)
// Car c = new Car();
// c.park();
public class Car {//�����ʹ� �⺻������ private
	private String color;//�ش� Ŭ���� �� pravate������ ���� �����ϱ� ���� setter��� �Լ� ����� ���
	private int cc;
	private int speed;

	public void drive() {
		speed = 60;
		System.out.println(color + "�� ���� �����Ѵ�. ���ݼӵ� :" + speed);
	}

	public void park() {
		speed = 0;
		System.out.println(color + "�� ���� �����Ѵ�. ���ݼӵ� :" + speed);
	}

	public void race() {
		speed = 120;
		System.out.println(color + "�� ���� �����Ѵ�. ���ݼӵ� :" + speed);
	}
	//setter, getter (color, cc, speed)
	//c1.methodName("color");
	//		c1.color = "red"; �̷��� ���ϰ�
	
	
	public void setColor(String color) {
		this.color = color;//this.�������� ���� 
	}
	
	public void setCc(int cc) {//c1.setCc(1500);
		this.cc = cc;//this.�������� ���� 
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;//this.�������� ���� 
	}
	//c1.getColor()
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
	
	
}
//�����͸� �ܺ����ٸ��ϰ� ���� Ŭ���� �� �޼���� �����Ҽ��ְ� ���� 
//�ܺο��� �����Ͱ���  ���Ƿ� �����Ҽ� ���� �ϰ� �ż���� ��

