package example;

import java.util.Scanner;

public class ex25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 0;
		double sum = 0;
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("input number : ");
		num = input.nextInt();
		for(i = 1; i <= num; i++) {
			sum = 1/i+sum;
		}
		
		System.out.println(sum);
	}

}
