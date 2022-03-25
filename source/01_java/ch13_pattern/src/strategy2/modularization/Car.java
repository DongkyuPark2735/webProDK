package strategy2.modularization;
// 3가지 부품 변수 / 생성자 x / 일반메소드 drive(), 추상 메소드 shape(),

//일반메소드  engine(), 일반메소드  km(), 일반메소드 fuel()

import strategy2.interfaces.IEngine;
import strategy2.interfaces.IFuel;
import strategy2.interfaces.IKm;

public abstract class Car {
	private IFuel fuel;
	private IEngine engine;
	private IKm km;

	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
	}

	public abstract void shape();

	public void engine() {
		engine.engine();
	}

	public void km() {
		km.km();
	}

	public void fuel() {
		fuel.fuel();
	}

	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}

	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public void setKm(IKm km) {
		this.km = km;
	}

}
