package Example_14;

import java.util.Arrays;
import java.util.Scanner;

public class Example_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] value = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int num, index = -1;
		
		Arrays.sort(value);
		
		System.out.println(Arrays.toString(value));
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("input index : ");
		num = scanner.nextInt();
		
		for(int i = 0; i < value.length; i++) {
			if(value[i] == num)
				index = i;
		}
		
		if(index < value.length && index >= 0) {
			System.out.println(num + " to location is " + index);
		}
	}

}
