package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.MissileYes;
import strategy1.step4.interfaces.knifeLazer;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes());// �ܺο��� set���� �����ϰ�
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new knifeLazer());// �������̽� �ν���Ʈ���� ��ü �����ؼ� set
	}

}