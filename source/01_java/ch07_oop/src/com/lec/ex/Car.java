package com.lec.ex;

// class : 데이터(속성, 인스턴트변수) 와 메소드(기능, setter, getter)
// Car c = new Car();
// c.park();
public class Car {//데이터는 기본적으로 private
	private String color;//해당 클래스 내 pravate형식의 값을 설정하기 위해 setter라는 함수 만들어 사용
	private int cc;
	private int speed;

	public void drive() {
		speed = 60;
		System.out.println(color + "색 차를 운전한다. 지금속도 :" + speed);
	}

	public void park() {
		speed = 0;
		System.out.println(color + "색 차를 주차한다. 지금속도 :" + speed);
	}

	public void race() {
		speed = 120;
		System.out.println(color + "색 차를 운전한다. 지금속도 :" + speed);
	}
	//setter, getter (color, cc, speed)
	//c1.methodName("color");
	//		c1.color = "red"; 이렇게 못하게
	
	
	public void setColor(String color) {
		this.color = color;//this.광역변수 지정 
	}
	
	public void setCc(int cc) {//c1.setCc(1500);
		this.cc = cc;//this.광역변수 지정 
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;//this.광역변수 지정 
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
//데이터를 외부접근못하게 막고 클래스 내 메서드로 설정할수있게 설정 
//외부에서 데이터값을  임의로 설정할수 없게 하고 매서드로 ㅈ

