package chapter05.test1;

public class Television {
	
	private int channel;
	private int volume;
	private boolean onOff;
	
	public Television() {
		this.channel = 0;
		this.volume = 0;
		this.onOff = false;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}
	
	public int getChannel() {
		return this.channel;
	}
	public int getVolume() {
		return this.volume;
	}
	public boolean getOnOff() {
		return this.onOff;
	}
	
}
