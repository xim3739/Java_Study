package Example_14;

import java.util.Arrays;

public class Example_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] value = {1.0, 2.0, 3.0, 4.0};
		double max = 0.0;
		
		System.out.println("value : " + Arrays.toString(value));
		
		max = value[0];
		
		for(int i = 0; i < value.length; i++) {
			if(value[i] > max) {
				max = value[i];
			}
		}
		
		System.out.println("sum is " + max);
	}

}
