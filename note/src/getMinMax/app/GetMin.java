package getMinMax.app;

import java.util.Arrays;

public class GetMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int INDEX = 10;
		
		int[] s = new int[INDEX];
		
		inputIntArray(s);
		printTorF(s);

	}
	
	public static void inputIntArray(int[] s) {
		for(int i = 0; i < s.length; i++) {
			s[i] = (int)(Math.random() * (50 - 10 + 1) + 10);
		}
		System.out.println(Arrays.toString(s));
	}
	
	public static void printTorF(int[] s) {
		
		int min = 0;
		
		min = s[0];
		
		for(int i = 0; i < s.length; i++) {
			if(s[i] < min ) {
				min = s[i];
			}
		}
		
		System.out.println("min is " + min);
	}

}
