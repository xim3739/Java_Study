package Example_14;

import java.util.Scanner;

public class Example_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int[] value = new int[10];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < value.length; i++) {
			System.out.print("input number (1 ~ 100) : ");
			value[i] = scanner.nextInt();
			if(num < 1 || num > 100) {
				System.out.println("wrong input number.");
			} else {
				value[i]++;
			}
		}
		
		System.out.println("check");
		
		for(int i = 0; i < value.length; i++) {
			System.out.print((i*10)+1 +" ~ " + (i+1)*10 + " ");
			for(int j = 0; j < value[i]; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}

}
