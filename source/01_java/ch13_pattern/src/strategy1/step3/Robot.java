package strategy1.step3;

//Robot을 상속받을 클래스 : SuperRobot , StandardRobot, LowRobot 
public abstract class Robot {
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

	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();

}
