package strategy1.step5.modularization;

import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;

//Robot r = new Robot();
//r.actionFly(); ���� (�����ڿ��� fly-new FlyNo();���ؼ�) �̸� �����ϰ�
	//IFly�� ��ü ������ �ȵ� 
public abstract class Robot {// ��ä ������� abstract
	private IFly fly;//�ν���Ʈ import��
	private IMissile missile;
	private IKnife knife;

	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}

	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}

	public void shape() {
		String className = getClass().getName();// Ŭ���� �̸� �������� strategy1.step2.SuperRobot
		int idx = className.lastIndexOf('.');// �Ǹ����� '.'�� �ִ� ��ġ�� ������ //���� ������������ Ŭ���� �� ��������
		String name = className.substring(idx + 1); // idx+1��° �۾����� ������
		System.out.println(name + "������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
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
