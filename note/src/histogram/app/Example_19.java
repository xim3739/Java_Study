package histogram.app;

import java.util.Scanner;

public class Example_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int[] value = new int[10];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < value.length; i++) {
			System.out.print((i+1) + " input number (1 ~ 100) : ");
			num = scanner.nextInt();
			if(num < 1 || num > 100) {
				System.out.println("wrong input number.");
			} else {
				if(num % value.length == 0) {
					value[num/value.length - 1]++;
				}
				value[num/value.length]++;
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
