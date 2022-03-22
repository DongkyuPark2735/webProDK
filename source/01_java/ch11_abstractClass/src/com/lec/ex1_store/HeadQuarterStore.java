package com.lec.ex1_store;
//HeadQuarterStore h1 = new HeadQuarterStore("본사") //추상클래스는 객체 생성 불가 
public abstract class HeadQuarterStore {
	private String str; // "본사" 점포 성질

	public HeadQuarterStore(String str) {
		this.str = str;
	}

	public abstract void kimchi();

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
