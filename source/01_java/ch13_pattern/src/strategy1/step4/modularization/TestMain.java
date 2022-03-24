package strategy1.step4.modularization;

public class TestMain {

	public static void main(String[] args) {
		Robot robots = new SuperRobot();
		robots.actionFly();
		robots.actionKnife();
		robots.actionMissile();
		
		((SuperRobot)robots).getKnife();//

	}

}
