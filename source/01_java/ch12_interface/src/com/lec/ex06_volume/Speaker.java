package com.lec.ex06_volume;

//Speaker s = new Speaker(3);
public class Speaker implements IVolume {
	private int volumeLevel;
	private static final int SPEAKER_MIN_VOLUME = 0;
	private static final int SPEAKER_MAX_VOLUME = 100;

	public Speaker() {
	}

	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumUp() {
		if (volumeLevel < SPEAKER_MIN_VOLUME) {
			volumeLevel++;
			System.out.println("Speaker ���� 1�÷� ����" + volumeLevel);
		} else {
			System.out.println("Speaker ������ �ִ�ġ���� �ø��� ���߽��ϴ�.");
		}
	}

	@Override
	public void volumUp(int level) {
		if (volumeLevel + level <= SPEAKER_MIN_VOLUME) {
			volumeLevel += level;
			System.out.println("Speaker ���� " + level + "��ŭ �÷Ƚ��ϴ�. ����" + volumeLevel);
		} else {
			int tempLevel = SPEAKER_MIN_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("Speaker ������ " + level + "��ŭ ���ø��� " + tempLevel + "��ŭ �÷Ƚ��ϴ�. �ִ�ġ" + SPEAKER_MIN_VOLUME);
		}
	}

	@Override
	public void volumDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("Speaker������ 1��ŭ ������ϴ�.");
		} else {
			System.out.println("Speaker������ �ּ�ġ���� ������ ���߽��ϴ�.");
		}
	}

	@Override
	public void volumDown(int level) {
		if (volumeLevel - level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("Speaker������ " + level + "��ŭ ������ϴ�. ���纼�� " + volumeLevel);
		} else {
			int tempLevel = volumeLevel; // �� �۰� ������ ������ ���簪��ŭ �����°�
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("Speaker������ " + level + "��ŭ �� ������" + tempLevel + "��ŭ ���Ƚ��ϴ�. ���纼��" + volumeLevel);
		}
	}

}
