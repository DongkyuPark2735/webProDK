package com.lec.ex5_monchild;

//Child first = new Child("첫째)
public class Child {
	private String name;
	static MomPouch momPouch;
//static 
	public Child() {
	}

	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}

	public void takeMoney(int money) {
		if (momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "가" + money + "원 가져가서 엄마지갑에 " + momPouch.money + "원 있다.");
		} else {
			System.out.println(name + "가 돈을 못받음. 현재 엄마 지갑에는" + momPouch.money + "원 밖에 없음");
		}
	}

}
