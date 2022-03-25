package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.MissileYes;
import strategy1.step4.interfaces.knifeLazer;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes());// 외부에서 set으로 접근하게
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new knifeLazer());// 인터페이스 인스턴트를에 객체 생성해서 set
	}

}