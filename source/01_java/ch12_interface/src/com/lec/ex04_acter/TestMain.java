package com.lec.ex04_acter;

public class TestMain {

	public static void main(String[] args) {

		Actor a1 = new Actor("�ں���");
//		Actor a1 = new IChef();
//		Actor a1 = new IChef();
//		Actor a1 = new IChef();
		a1.canCatchCriminal();
		a1.canSerch();
		a1.outFire();
		a1.saveMan();
		a1.makePizza();
		a1.makeSpaghetti();
		IChef chefPark = new Actor("�ڿ丮��");
//		chefPark.canCatchCriminal();�Ұ�
		chefPark.makePizza();
//		chefPark.canC);
//		 Actor firePark = new IFireFighter ("�ڿ丮��");
//		 IFireFighter firePark = new IFireFighter("�ڿ丮��");
		
		
	}

}
