package strategy2.modularization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

//상속받은 맴버 : 3가지 부품변수 /
public class Genesis extends Car {

	public Genesis() {
		setEngine(new EngineHigh());
		setFuel(new FuelGasoline());
		setKm(new Km10());
	}

	@Override
	public void shape() {
		System.out.println("제네시스 모양은 door, sheet, handle로 이루어져 있습니다");
	}
}
