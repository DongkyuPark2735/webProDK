package com.lec.ex06_volume;

//Tv tv = new TV(3);
public class TV implements IVolume {
	private int volumeLevel;
	private static final int TV_MIN_VOLUME = 0;
	private static final int TV_MAX_VOLUME = 50;

	public TV() {
	}

	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumUp() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ���� 1�÷� ����" + volumeLevel);
		} else {
			System.out.println("TV ������ �ִ�ġ���� �ø��� ���߽��ϴ�.");
		}
	}

	@Override
	public void volumUp(int level) {
		if (volumeLevel + level <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV ���� " + level + "��ŭ �÷Ƚ��ϴ�. ����" + volumeLevel);
		} else {
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ " + level + "��ŭ ���ø��� " + tempLevel + "��ŭ �÷Ƚ��ϴ�. �ִ�ġ" + TV_MAX_VOLUME);
		}
	}

	@Override
	public void volumDown() {
		if (volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV������ 1��ŭ ������ϴ�.");
		} else {
			System.out.println("TV������ �ּ�ġ���� ������ ���߽��ϴ�.");
		}
	}

	@Override
	public void volumDown(int level) {
		if (volumeLevel - level > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV������ " + level + "��ŭ ������ϴ�. ���纼�� " + volumeLevel);
		} else {
			int tempLevel = volumeLevel; // �� �۰� ������ ������ ���簪��ŭ �����°�
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV������ " + level + "��ŭ �� ������" + tempLevel + "��ŭ ���Ƚ��ϴ�. ���纼��" + volumeLevel);
		}
	}

}
