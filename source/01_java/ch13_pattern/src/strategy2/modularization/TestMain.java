package strategy2.modularization;

import strategy2.interfaces.FuelHybride;
import strategy2.interfaces.Km20;

public class TestMain {

	public static void main(String[] args) {
		Car genesis = new Genesis();
		Car sonata = new Sonata();
		Car accent = new Accent();

		Car[] cars = { genesis, sonata, accent };

//		sonata.setKm(km);
//		sonata.setFuel(FuelHybride());
		for (Car car : cars) {
			System.out.println("-----------------------");
			car.drive();
			car.engine();
			car.fuel();
			car.km();
			car.shape();
			System.out.println("-----------------------");
		}
		System.out.println("-----------------------");
		System.out.println("소나타를 하이브리드로 교체하고 연비를 20km/l로 교체해 주세요");
		sonata.setKm(new Km20());
		sonata.setFuel(new FuelHybride());
		for (int i = 0; i < cars.length; i++) {
			System.out.println("-----------------------");
			cars[i].drive();
			cars[i].engine();
			cars[i].fuel();
			cars[i].km();
			cars[i].shape();
			System.out.println("-----------------------");
		}

	}

}
