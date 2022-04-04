package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("홍", "010-9999-9999");
		friends[1] = new Friend("김", "010-8888-8888");

		for (int i = 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}
		/*** ArrayList : index가 있고, 중복 허용 ***/
		ArrayList<Friend> fs = new ArrayList<Friend>();
		fs.add(new Friend("홍", "010-9999-9999"));// 0번 인덱스 //
		fs.add(2, new Friend("김", "010-8888-8888"));// 1번 인덱스 //앞선 인덱스에 자료가 없는데 2번에 추가 불가 차곡차곡 넣어야함?
		Friend temp = new Friend("이", "010-7777-7777", new Date(95, 11, 12));
		fs.add(temp); // 2번 인덱스 Ex) 1번 3번 자료있는데 2번 null 불가
		for (int i = 0; i < fs.size(); i++) {
			System.out.println(fs.get(i));
		}

	}
}
