package com.lec.ex11_final;

public final class Rabbit extends Animal {

	@Override
	public void running() {
		setSpeed(getSpeed()+30);
		System.out.println("마구 뛰어요. 현재속도 : "+ getSpeed());
	}
}
