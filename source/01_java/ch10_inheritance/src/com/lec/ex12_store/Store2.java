package com.lec.ex12_store;

public class Store2 extends HeadQuarterStore {

	public Store2(String str) {
		super(str);
	}

	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ - 5,000¿ø");
	}

	private void gog() {
		System.out.println("°ø±ê¹ä - ¹«·á");
	}

	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä - 5,000¿ø");
	}
}
