package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("ȫ", "010-9999-9999");
		friends[1] = new Friend("��", "010-8888-8888");

		for (int i = 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}
		/*** ArrayList : index�� �ְ�, �ߺ� ��� ***/
		ArrayList<Friend> fs = new ArrayList<Friend>();
		fs.add(new Friend("ȫ", "010-9999-9999"));// 0�� �ε��� //
		fs.add(2, new Friend("��", "010-8888-8888"));// 1�� �ε��� //�ռ� �ε����� �ڷᰡ ���µ� 2���� �߰� �Ұ� �������� �־����?
		Friend temp = new Friend("��", "010-7777-7777", new Date(95, 11, 12));
		fs.add(temp); // 2�� �ε��� Ex) 1�� 3�� �ڷ��ִµ� 2�� null �Ұ�
		for (int i = 0; i < fs.size(); i++) {
			System.out.println(fs.get(i));
		}

	}
}
