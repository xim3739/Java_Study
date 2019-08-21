package chapter05.test1;

public class TelevisionTest {

	public static void main(String[] args) {
		
		Television tv = new Television();
		
		tv.setChannel(20);
		tv.setVolume(30);
		tv.setOnOff(true);
		
		System.out.println("tv channel is " + tv.getChannel());
		System.out.println("tv volume is " + tv.getVolume());
		System.out.println("tv onOff is " + tv.getOnOff());
		
	}

}
