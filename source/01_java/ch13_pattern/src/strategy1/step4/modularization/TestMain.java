package strategy1.step4.modularization;

public class TestMain {

	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot LowR = new LowRobot();

		Robot[] robots = { superR, standardR, LowR };

		for (Robot robot : robots) {
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
			robot.actionRun();
			robot.actionWalk();
			robot.shape();
		
		
		}
//		LowR.setFly(new FlyYes()); 5단계에서 해결할 예정
	}
}
