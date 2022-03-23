package com.lec.ex04_acter;

public class Actor implements IChef, IPoliceMan, IFireFighter {
	private String name;

	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void outFire() {
		System.out.println(name + "은 불을 끌수  있습니다.");

	}

	@Override
	public void saveMan() {
		System.out.println(name + "은 사람을 구할수 있습니다..");

	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "은 범인을 잡습니다.");
	}

	@Override
	public void canSerch() {
		System.out.println(name + "은 찾을수 있습니다..");

	}

	@Override
	public void makePizza() {
		System.out.println(name + "은 피자요리를 할 수 있습니다.");

	}

	@Override
	public void makeSpaghetti() {
		// TODO Auto-generated method stub
		System.out.println(name + "은 스파게티를  있습니다.");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
