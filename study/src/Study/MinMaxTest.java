package Study;

import java.util.Arrays;

public class MinMaxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int INDEX = 10;
		
		int[] number = new int[INDEX];
		int max = 0;
		
		number = inputNumber(number);
		max = findMaxValue(number);
		
		System.out.print("number : " + Arrays.toString(number) + "\n");
		System.out.println("max is " +max);
		
	}
	
	public static int[] inputNumber(int[] number) {
		
		for(int i = 0; i < number.length; i++) {
			
			number[i] = (int)(Math.random() * 20 + 1);
		}
		
		return number;
	}
	
	public static int findMaxValue(int[] number) {
		
		int max = 0;
		
		max = number[0];
		
		for(int i = 0; i < number.length; i++) {
			
			if(number[i] > max) {
				
				max = number[i];
			}
		}
		
		return max;
	}

}
