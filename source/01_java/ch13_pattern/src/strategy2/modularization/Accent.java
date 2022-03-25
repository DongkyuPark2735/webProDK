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
		System.out.println("Accent 외형은 door, sheet, handle로 이루어져 있습니다");
	}

}
