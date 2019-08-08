package Chapter02;

public class LightTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lightSpeed = 0L;
		long distance = 0L;
		
		lightSpeed = 300_000L;
		distance = lightSpeed * 365 * 24 * 60 * 60;
		
		System.out.println("1 year light speed of distance : " + distance + "km.");
		System.out.printf("1 year light speed of distance : %dkm.", distance);
	}

}
