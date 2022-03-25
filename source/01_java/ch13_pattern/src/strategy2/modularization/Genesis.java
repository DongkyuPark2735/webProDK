package strategy2.modularization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

//��ӹ��� �ɹ� : 3���� ��ǰ���� /
public class Genesis extends Car {

	public Genesis() {
		setEngine(new EngineHigh());
		setFuel(new FuelGasoline());
		setKm(new Km10());
	}

	@Override
	public void shape() {
		System.out.println("���׽ý� ����� door, sheet, handle�� �̷���� �ֽ��ϴ�");
	}
}
