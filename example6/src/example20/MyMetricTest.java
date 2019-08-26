package example20;

public class MyMetricTest {

	public static void main(String[] args) {
		MyMetric m1 = new MyMetric(3.0, 5.0);
		
		System.out.println(MyMetric.kiloToMiles());
		System.out.println(MyMetric.mileToKilos());
	}

}
