package Example_14;

import java.util.Arrays;

public class Example_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] value = new double[10];
		
		init(value);
		
		System.out.println(Arrays.toString(value));
	}
	
	public static void init(double[] value) {
		for(double i = 0; i < value.length; i++) {
			value[(int)i] = i + 1;
		}
	}
}
