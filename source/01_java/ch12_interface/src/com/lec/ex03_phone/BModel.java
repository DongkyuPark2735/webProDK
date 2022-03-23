package com.lec.ex03_phone;

public class BModel implements IAcorperation {

	private String modelName;

	public BModel() {
		modelName = "B 모델";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송수신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV 리모콘 탑재");
	}

}
