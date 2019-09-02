package example19;

public class Test {

	public static void main(String[] args) {
		controllable videoControll = new controllable() {
			
			@Override
			public void stop() {
				System.out.println("Stop");
				
			}
			
			@Override
			public void play() {
				System.out.println("Start");
				
			}
		};
		
	}

}
