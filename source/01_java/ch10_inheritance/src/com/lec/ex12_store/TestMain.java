package com.lec.ex12_store;

public class TestMain {

	public static void main(String[] args) {

		HeadQuarterStore[] store = { new HeadQuarterStore("= = = 본사= = ="),
									 new Store1("= = =1호점= = ="),
									 new Store2("= = =2호점= = ="), 
									 new Store3("= = =3호점= = =") };
		//store[4] = new Store2("다른 호점");
//		for (int i = 0; i < store.length; i++) {
//			System.out.println(store[i].getStr());
//			store[i].bibim();
//			store[i].bude();
//			store[i].kimchi();
//			store[i].sunde();
//			store[i].gonggibab();
//		}
		
		for (HeadQuarterStore st : store) {
			System.out.println(st.getStr());
			st.bibim();
			st.bude();
			st.kimchi();
			st.sunde();
			st.gonggibab();
		}

	}

}
