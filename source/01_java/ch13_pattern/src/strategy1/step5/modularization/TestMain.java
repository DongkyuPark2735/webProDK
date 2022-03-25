package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.FlyYes;

public class TestMain {
//5단계 : 기능을 부품화 -> 유지보수를 간편하게
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
		//SuperRobot 업그레이드 요청 날수 있습니다. -> 높이 고공비행합니다로
		//고공비행하는 부품 만들어 setFly만 호출
	}
}
