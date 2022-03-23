package com.lec.ex03_phone;

public class AModel implements IAcorperation {
	private String modelName;
	
	
	public AModel() {
		modelName = "A 모델";
	}


	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName+"은 5G");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV 리모콘 탑재");
	}

}
