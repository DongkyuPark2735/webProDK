package com.lec.ex10_customer;

//address, sum, point, date, vip 
//Customer c = new Customer("홍", "010", "설", "1995-12-12"
public class Customer extends Person {
	private String address;
	private int sum;// 구매 누적금액
	private int point;// 포인트(구매마다 5%적립)
	private String date;// 기념일(date타입 될 예정)
	private boolean vip;// true면 vip fales면 일반

	public Customer(String name, String tel, String address, String date) {
		super(name, tel);// 반드시 첫번째 라인에 와야함
		this.address = address;
		this.date = date;
		point = 1000;// 새 고객에는 1000포인트 자동부여
		System.out.println(name + "님 등록되었습니다. 포인트 1000점을 선물로드립니다.");
	}

	public void buy(int price) {// c.buy(10000);
		sum += price;
		int tempPoint = (int) (price * 0.05);// 전체 괄호 후 앞에 ㅈ자료형 자료형에만 하면 괄호먼저 실행
		point += tempPoint;
		System.out.println(getName() + "님 감사합니다. 금번 포인트 :" + tempPoint + "점 추가되어 총 포인트 :" + point);
		if (sum >= 1000000 && vip == false) {
			vip = true;//구매 누적음액이 100만원 이상시 vip고객으로
			System.out.println(getName()+"님 vip고객으로 업그레이드 되셨습니다.");
		}
	}	
	@Override //오버라이딩 확인  @:어노테이션 ,실행하지않고 컴퓨터에게 알려줌 , 해당줄은 영향x
	public String infoString() {
		return super.infoString() + "[주소]" +address+"[포인트]"+point+"[누적금액]"+sum;
	}

}
