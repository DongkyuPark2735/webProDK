package com.lec.ex04_acter;

public class TestMain {

	public static void main(String[] args) {

		Actor a1 = new Actor("박보검");
//		Actor a1 = new IChef();
//		Actor a1 = new IChef();
//		Actor a1 = new IChef();
		a1.canCatchCriminal();
		a1.canSerch();
		a1.outFire();
		a1.saveMan();
		a1.makePizza();
		a1.makeSpaghetti();
		IChef chefPark = new Actor("박요리사");
//		chefPark.canCatchCriminal();불가
		chefPark.makePizza();
//		chefPark.canC);
//		 Actor firePark = new IFireFighter ("박요리사");
//		 IFireFighter firePark = new IFireFighter("박요리사");
		
		
	}

}
