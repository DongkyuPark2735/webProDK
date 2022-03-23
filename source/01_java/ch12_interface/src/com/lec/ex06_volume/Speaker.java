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
			System.out.println("Speaker 볼륨 1올려 현재" + volumeLevel);
		} else {
			System.out.println("Speaker 볼륨이 최대치여서 올리지 못했습니다.");
		}
	}

	@Override
	public void volumUp(int level) {
		if (volumeLevel + level <= SPEAKER_MIN_VOLUME) {
			volumeLevel += level;
			System.out.println("Speaker 볼륨 " + level + "만큼 올렸습니다. 현재" + volumeLevel);
		} else {
			int tempLevel = SPEAKER_MIN_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("Speaker 볼륨을 " + level + "만큼 못올리고 " + tempLevel + "만큼 올렸습니다. 최대치" + SPEAKER_MIN_VOLUME);
		}
	}

	@Override
	public void volumDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("Speaker볼륨을 1만큼 낮췄습니다.");
		} else {
			System.out.println("Speaker볼륨이 최소치여서 내리지 못했습니다.");
		}
	}

	@Override
	public void volumDown(int level) {
		if (volumeLevel - level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("Speaker볼륨을 " + level + "만큼 낮췄습니다. 현재볼륨 " + volumeLevel);
		} else {
			int tempLevel = volumeLevel; // 더 작게 내릴수 없으니 현재값만큼 내리는것
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("Speaker볼륨을 " + level + "만큼 못 내리고" + tempLevel + "만큼 내렸습니다. 현재볼륨" + volumeLevel);
		}
	}

}
