package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {

	public LowRobot() {
		setFly(new FlyNo());
		setKnife(new KnifeNo());
		setMissile(new MissileNo());
	}

}
