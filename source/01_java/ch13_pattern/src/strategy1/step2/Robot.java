package strategy1.step2;
//Robot�� ��ӹ��� Ŭ���� : SuperRobot , StandardRobot, LowRobot 
public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String className = getClass().getName();//Ŭ���� �̸� ��������  strategy1.step2.SuperRobot 
		int idx = className.lastIndexOf('.');//�Ǹ����� '.'�� �ִ� ��ġ�� ������ 	//���� ������������ Ŭ���� �� �������� 
		String name = className.substring(idx +1); //idx+1��° �۾����� ������
		System.out.println(name + "������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	
	
}
