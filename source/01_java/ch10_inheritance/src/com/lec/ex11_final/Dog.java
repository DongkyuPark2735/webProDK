package com.lec.ex11_final;

public class Dog extends Animal{
	@Override
	public void running() {
		setSpeed(getSpeed() + 10);// speed +10;
		System.out.println("²¿¸®¸¦ Èçµé¸ç ¶Ù¾î¿ä. ÇöÀç¼Óµµ :"+getSpeed());

	}

}
