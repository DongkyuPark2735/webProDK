package com.lec.ex;

import javax.xml.soap.Text;

public class Ex06_multi {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[][] test = { { 1, 2, 3 }, { 4, 5, 6 } };

		System.out.println(arr[2]);
		System.out.println(test[0][0]);
//다중배열의 값은 행값  다중배열[행]의 값은 열값
		for (int i = 0; i < test.length; i++) {
			System.out.println();
			for (int j = 0; j < test[i].length; j++) {
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);

			}
		}

	}
}
