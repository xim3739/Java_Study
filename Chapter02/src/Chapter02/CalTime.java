package Chapter02;

public class CalTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double LIGHT_SPEED = 30e4;
		double distance = 40e12;
		double lightYear = 0.0;
		double secs = 0.0;
		
		secs = distance / LIGHT_SPEED;
		
		lightYear= secs/(60.0 * 60.0 * 24.0 * 365.0);
		
		System.out.println("running time is " + lightYear);
	}

}
