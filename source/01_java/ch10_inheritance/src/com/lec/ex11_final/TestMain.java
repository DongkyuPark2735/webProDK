package com.lec.ex11_final;

public class TestMain{
	public static void main(String[] args) {
		Animal[] animal = {new Dog(), new Rabbit()};

		for(Animal an : animal) {
			an.running();
			an.running();
			an.stop();
			
		}
		
		
//		animal[1].running();
//		animal[1].running();
//		animal[1].stop();
	}
	
}
