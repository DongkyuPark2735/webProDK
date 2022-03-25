package strategy2.modularization;
// 3���� ��ǰ ���� / ������ x / �Ϲݸ޼ҵ� drive(), �߻� �޼ҵ� shape(),

//�Ϲݸ޼ҵ�  engine(), �Ϲݸ޼ҵ�  km(), �Ϲݸ޼ҵ� fuel()

import strategy2.interfaces.IEngine;
import strategy2.interfaces.IFuel;
import strategy2.interfaces.IKm;

public abstract class Car {
	private IFuel fuel;
	private IEngine engine;
	private IKm km;

	public void drive() {
		System.out.println("����̺� �� �� �ֽ��ϴ�.");
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
