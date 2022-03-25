package com.lec.ex1_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "       ja            va       ";
		System.out.println("1."+str1.concat(str2)); //abcXabcABCXabc StringµÎ°³ ´õÇÏ±â
		System.out.println("2."+str1.substring(3));// Xabc 3¹øÂ° ¹®ÀÚºÎÅÍ
		System.out.println("3."+str1.substring(3,5));//Xa 3¹øÂ° ¹®ÀÚºÎÅÍ 5¹øÂ° ¾Õ±îÁö
		System.out.println("4."+str1.length());// 7 ±æÀÌ
		System.out.println("5."+str1.toUpperCase());// ABCXABC ´ë¹®ÀÚ·Î ´ë¹®ÀÚ´Â ±×´ë·ÎµÒ 
		System.out.println("6."+str1.toLowerCase());// abcxabc ¼Ò¹®ÀÚ·Î ¼Ò¹®ÀÚ´Â ±×´ë·ÎµÒ
		System.out.println("7."+str1.charAt(3));// 3¹øÂ° ¹®ÀÚ Ãâ·Â 'x'
		System.out.println("8."+str1.indexOf('b'));//Ã¹¹øÂ°'b'°¡ ³ª¿À´Â ÀÎµ¦½º 1
		System.out.println("9."+str1.indexOf('b', 3));//3¹øÂ° ºÎÅÍ b°¡ ¾îµğ³ª¿À´ÂÁö °Ë»öÇØ¼­ Ã¹¹øÂ° 'b'À§Ä¡ 
		System.out.println("10."+str1.indexOf("abc")); //Ã¹¹øÂ° "abc"³ª¿À´Â À§Ä¡
		System.out.println("11."+str1.indexOf("abc" , 3)); //3¹øÂ° "abc"³ª¿À´Â À§Ä¡ ¾øÀ¸¸é -1
		System.out.println("12."+str1.indexOf('z')); //¾øÀ¸¸é -1
		System.out.println("13."+str1.lastIndexOf('b')); //¸¶Áö¸· 'b'À§Ä¡ 4 
		System.out.println("14."+str1.lastIndexOf('b', 3)); //¸¶Áö¸· 'b' 3¹øÂ° ºÎÅÍ ¾ÕÀ¸·Î
		System.out.println("15."+str1.equals(str2)); //str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false 
		System.out.println("16."+str1.equalsIgnoreCase(str2)); //str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö ´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀÌ true 
		System.out.println("17."+str3.trim()); //¾ÕµÚ°ø¹é Á¦°Å  ja       va
		System.out.println("18."+str1.replace('a', '9')); // 'a'¸¦ '9'·Î ¼öÁ¤ 9bcX9bc
		System.out.println("19."+str1.replace("ab", "¡Ú")); // ¹®ÀÚ¿­À» ¼öÁ¤ 19.¡ÚX¡Ú
		System.out.println("20."+str3.replace(" ", "")); // ½ºÆäÀÌ½º ÇÑÄ­À» ºó¹®ÀÚ¿­·Î 
		System.out.println("21."+str1.replaceAll("abc", "Z")); // "abc"¸¦ "Z"·Î 
//		System.out.println("21."+str1.replaceAll); // "abc"¸¦ "Z"·Î 
								//Á¤±ÔÇ¥Çö½Ä ?
		String str = "¾È³çHello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));//¾ËÆÄºªÀ» ""·Î ¼öÁ¤ 
		//Çü½Ä ÀÚÃ¼¸¦ ÀÌÇØÇÏ´Â°Ô ¾Æ´Ï¶ó Æ¯Á¤ÇÑ ÀÔ·Â½ÄÀÌ ÀÖ´Ù. 
		String i;
		System.out.println(str.replaceAll("[°¡-ÆR]", ""));//ÇÑ±Û¹®ÀÚ¸¦ ""·Î ¼öÁ¤
		//¹®ÀÚ¿­ ¸Å¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤¾ÈÇÔ
		System.out.println(str1+str2+str);
	}
}
