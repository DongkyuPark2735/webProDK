package com.lec.ex11_robot;
//RobotOrder order = new Ro
//order.action(draw형 객체
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof SingRobot) {
			((SingRobot) robot).sing();
		}else if(robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
		}else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).draw();
		}else {
			System.out.println("확장된 로봇이면 이곳에 구현하세요");
		}//각기 다른 메소드들을 한군데서 사용하기위해 자료형을 맞춘다. 
		//비어있는 인터페이스로 묶고 자료형을 
	}
}
