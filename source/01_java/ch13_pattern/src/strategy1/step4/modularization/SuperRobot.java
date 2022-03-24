package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.MissileYes;
import strategy1.step4.interfaces.knifeLazer;

public class SuperRobot extends Robot {
	private IFly fly;
	//자료형 타입을 IFly로 해서 나중에 추가할 항목이있을때 
	private IMissile missile;
	private IKnife knife;
	
	public SuperRobot() {
		setFly(new FlyYes());//외부에서 접근
		setMissile(new MissileYes());	//	missile = new MissileYes();
		setKnife(new knifeLazer());
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

	
	public IKnife getKnife() {
		return knife;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

	public IMissile getMissile() {
		return missile;
	}
	
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
}
