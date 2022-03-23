package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		IVolume[] volumes = { new TV(3), new Speaker(5), new TV(10), new Speaker(7) };

		for (IVolume i : volumes) {

			i.volumDown();
			i.volumDown(20);
			i.volumUp(10);
			i.volumUp(45);
			System.out.println("~~~~~~~~~~");

		}
	}
}
