package com.lec.ex12_store;

public class TestMain {

	public static void main(String[] args) {

		HeadQuarterStore[] store = { new HeadQuarterStore("= = = ����= = ="),
									 new Store1("= = =1ȣ��= = ="),
									 new Store2("= = =2ȣ��= = ="), 
									 new Store3("= = =3ȣ��= = =") };
		//store[4] = new Store2("�ٸ� ȣ��");
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
