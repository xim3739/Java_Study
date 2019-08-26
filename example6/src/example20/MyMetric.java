package example20;

public class MyMetric {
	
	public final static double KILO_TO_MILE = 0.625;
	public final static double MILE_TO_KILO = 1.609;
	
	private static double kilo;
	private static double mile;
	
	public MyMetric() {
		this(0.0, 0.0);
	}
	public MyMetric(double kilo, double mile) {
		MyMetric.kilo = kilo;
		MyMetric.mile = mile;
	}
	
	public static double kiloToMiles() {
		return kilo * KILO_TO_MILE;
	}
	public static double mileToKilos() {
		return mile * MILE_TO_KILO;
	}
}
