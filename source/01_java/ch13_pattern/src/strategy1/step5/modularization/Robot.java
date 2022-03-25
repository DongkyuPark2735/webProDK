package strategy1.step5.modularization;

import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;

//Robot r = new Robot();
//r.actionFly(); 에러 (생성자에서 fly-new FlyNo();안해서) 이를 방지하게
	//IFly의 객체 생성이 안됨 
public abstract class Robot {// 객채 못만들게 abstract
	private IFly fly;//인스턴트 import함
	private IMissile missile;
	private IKnife knife;

	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}

	public void shape() {
		String className = getClass().getName();// 클래스 이름 가져오기 strategy1.step2.SuperRobot
		int idx = className.lastIndexOf('.');// 맨마지막 '.'이 있는 위치를 정수로 //아직 생성되지않은 클래스 명 가져오기
		String name = className.substring(idx + 1); // idx+1번째 글씨부터 끝까지
		System.out.println(name + "외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}

	public void actionFly() {
		fly.fly();
	}

	public void actionMissile() {
		missile.missile();
	}

	public void actionKnife() {
		knife.Knife();
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

	public IFly getFly() {
		return fly;
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}
}
