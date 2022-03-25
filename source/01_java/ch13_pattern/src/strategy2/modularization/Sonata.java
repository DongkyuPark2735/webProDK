package strategy2.modularization;

import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km15;

public class Sonata extends Car {

	public Sonata() {
		setEngine(new EngineMid());
		setFuel(new FuelGasoline());
		setKm(new Km15());
	}

	@Override
	public void shape() {
		System.out.println("�ҳ�Ÿ ������ door, sheet, handle�� �̷���� �ֽ��ϴ�");
	}

}
