package example13;

public class MyMathTest {

	public static void main(String[] args) {
		MyMath<Integer> intMath = new MyMath<Integer>();
		MyMath<Double> doubleMath = new MyMath<Double>();
		
		intMath.getAverage();
		doubleMath.getAverage();
	}

}
