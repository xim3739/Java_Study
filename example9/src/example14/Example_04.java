package example14;

import java.util.Arrays;

public class Example_04 {
	
	public static void main(String args[ ]) {
		double[] darray = {0.0, 2.1, 4.0, 1.2, 3.2};
		
		Arrays.sort(darray);
		
		for(double i : darray) {
			System.out.println(i);
		}
		
	}
	
}
