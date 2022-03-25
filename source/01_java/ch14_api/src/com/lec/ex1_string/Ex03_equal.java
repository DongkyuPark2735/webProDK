package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03_equal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I : input | U : update | X : exit");
			fn = scanner.next(); // XxIiUu ...

			switch (fn) {
			case "i":
			case "I":
				System.out.println("input로직 있을곳 ");
			case "u":
			case "U":
				System.out.println("update 로직 있을곳 ");
			}
		} while (!fn.equalsIgnoreCase("x"));

	}
}
