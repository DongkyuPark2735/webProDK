package com.lec.ex1_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "       ja            va       ";
		System.out.println("1."+str1.concat(str2)); //abcXabcABCXabc String두개 더하기
		System.out.println("2."+str1.substring(3));// Xabc 3번째 문자부터
		System.out.println("3."+str1.substring(3,5));//Xa 3번째 문자부터 5번째 앞까지
		System.out.println("4."+str1.length());// 7 길이
		System.out.println("5."+str1.toUpperCase());// ABCXABC 대문자로 대문자는 그대로둠 
		System.out.println("6."+str1.toLowerCase());// abcxabc 소문자로 소문자는 그대로둠
		System.out.println("7."+str1.charAt(3));// 3번째 문자 출력 'x'
		System.out.println("8."+str1.indexOf('b'));//첫번째'b'가 나오는 인덱스 1
		System.out.println("9."+str1.indexOf('b', 3));//3번째 부터 b가 어디나오는지 검색해서 첫번째 'b'위치 
		System.out.println("10."+str1.indexOf("abc")); //첫번째 "abc"나오는 위치
		System.out.println("11."+str1.indexOf("abc" , 3)); //3번째 "abc"나오는 위치 없으면 -1
		System.out.println("12."+str1.indexOf('z')); //없으면 -1
		System.out.println("13."+str1.lastIndexOf('b')); //마지막 'b'위치 4 
		System.out.println("14."+str1.lastIndexOf('b', 3)); //마지막 'b' 3번째 부터 앞으로
		System.out.println("15."+str1.equals(str2)); //str1과 str2가 같은 문자열인지 false 
		System.out.println("16."+str1.equalsIgnoreCase(str2)); //str1과 str2가 같은 문자열인지 대소문자 구분없이 true 
		System.out.println("17."+str3.trim()); //앞뒤공백 제거  ja       va
		System.out.println("18."+str1.replace('a', '9')); // 'a'를 '9'로 수정 9bcX9bc
		System.out.println("19."+str1.replace("ab", "★")); // 문자열을 수정 19.★X★
		System.out.println("20."+str3.replace(" ", "")); // 스페이스 한칸을 빈문자열로 
		System.out.println("21."+str1.replaceAll("abc", "Z")); // "abc"를 "Z"로 
//		System.out.println("21."+str1.replaceAll); // "abc"를 "Z"로 
								//정규표현식 ?
		String str = "안녕Hello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));//알파벳을 ""로 수정 
		//형식 자체를 이해하는게 아니라 특정한 입력식이 있다. 
		String i;
		System.out.println(str.replaceAll("[가-힣]", ""));//한글문자를 ""로 수정
		//문자열 매소드는 문자열을 수정안함
		System.out.println(str1+str2+str);
	}
}
