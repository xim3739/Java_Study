package Chapter03;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		int max = 0;
		int min = 0;
		
		num1 = inputNumber();
		num2 = inputNumber();
		
		max = maxValue(num1, num2);
		min = minValue(num1, num2);
		
		GCD(max, min);
		
	}
	
	public static int inputNumber() {
		int num = 0;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("input number (1 ~ 100) : ");
			num = input.nextInt();
			
			if(num < 1 || num > 100) {
				System.out.println("wrong input number ... try again");
			} else {
				break;
			}
		}
		return num;
	}
	public static int maxValue(int num1, int num2) {
		
		int max = 0;
		
		if(num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		
		return max;
	}
	public static int minValue(int num1, int num2) {
		
		int min = 0;
		
		if(num1 > num2) {
			min = num2;
		} else {
			min = num1;
		}
		
		return min;
	}
	public static void GCD (int max, int min) {
		
		int result = 0;
		
		while(true) {
			if(min == 0) {
				System.out.println("GDC is " + max);
				break;
			} else {
				result = max % min;
				max = min;
				min = result;
			}
		}
	}
}
