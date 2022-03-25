package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;

	public LowRobot() {
		setFly(new FlyNo());
		setKnife(new KnifeNo());
		setMissile(new MissileNo());
	}

	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.Knife();

	}

	public IFly getFly() {
		return fly;
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public IMissile getMissile() {
		return missile;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public IKnife getKnife() {
		return knife;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
