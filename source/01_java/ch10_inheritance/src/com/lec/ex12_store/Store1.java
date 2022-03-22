package com.lec.ex12_store;

public class Store1 extends HeadQuarterStore {
	
	public Store1(String str) {
		super(str);
	}
	
	@Override
	public void sunde() {
		System.out.println("¼ø´ñ±¹ - ¾ÈÆÈ¾Æ");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ - 5,000¿ø");
	}

}
