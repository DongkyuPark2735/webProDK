package com.lec.ex04_acter;

public class Actor implements IChef, IPoliceMan, IFireFighter {
	private String name;

	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void outFire() {
		System.out.println(name + "�� ���� ����  �ֽ��ϴ�.");

	}

	@Override
	public void saveMan() {
		System.out.println(name + "�� ����� ���Ҽ� �ֽ��ϴ�..");

	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "�� ������ ����ϴ�.");
	}

	@Override
	public void canSerch() {
		System.out.println(name + "�� ã���� �ֽ��ϴ�..");

	}

	@Override
	public void makePizza() {
		System.out.println(name + "�� ���ڿ丮�� �� �� �ֽ��ϴ�.");

	}

	@Override
	public void makeSpaghetti() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ���İ�Ƽ��  �ֽ��ϴ�.");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
