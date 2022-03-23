package com.lec.ex03_phone;

public class TestMain {
	public static void main(String[] args) {
		IAcorperation[] p1 = {new AModel(),new BModel(),new CModel()};
		
//		 AModel a = new AModel();
//		 BModel b = new BModel();
//		 CModel c = new CModel();
		
		for(IAcorperation i : p1) {//i.getClass().getName() = com.lec.ex03_phone.CModel 클래스의 이름 
			System.out.println(i.getClass().getName());
			i.dmbReceive();
			i.lte();
			i.tvRemoteControl();
		}

			
	}
}
