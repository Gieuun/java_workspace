package com.sds.project0304.music;

public abstract class MusicPlayer {
	int vol;
	
	//이 클래스를 상속받는 자식이 누군지는 모르겠지만, 니가 좀 알아서 상황에 맞게
	//커스터마이징해라! (오버라이딩 해서 써라)
	public abstract void setVolume();
	
	public abstract void playerMp3File();
}
