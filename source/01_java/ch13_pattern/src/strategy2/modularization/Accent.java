package strategy2.modularization;

import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km20;

public class Accent extends Car {

	public Accent() {
		setEngine(new EngineLow());
		setFuel(new FuelDiesel());
		setKm(new Km20());
	}

	@Override
	public void shape() {
		System.out.println("Accent ������ door, sheet, handle�� �̷���� �ֽ��ϴ�");
	}

}
