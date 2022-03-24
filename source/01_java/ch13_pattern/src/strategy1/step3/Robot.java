package strategy1.step3;

//Robot�� ��ӹ��� Ŭ���� : SuperRobot , StandardRobot, LowRobot 
public abstract class Robot {
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

	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();

}
