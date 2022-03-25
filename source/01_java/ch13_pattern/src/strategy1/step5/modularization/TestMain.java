package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.FlyYes;

public class TestMain {
//5�ܰ� : ����� ��ǰȭ -> ���������� �����ϰ�
	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot LowR = new LowRobot();

		superR.setFly(new FlyHigh());
		Robot[] robots = { superR, standardR, LowR };

		for (Robot robot : robots) {
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
			robot.actionRun();
			robot.actionWalk();
			robot.shape();
		
		
		}
		//SuperRobot ���׷��̵� ��û ���� �ֽ��ϴ�. -> ���� ��������մϴٷ�
		//��������ϴ� ��ǰ ����� setFly�� ȣ��
	}
}
