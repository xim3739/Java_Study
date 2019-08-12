package example;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		int max = 0;
		int min = 0;
		int count = 0;
		
		for(;;) {
			num1 = inputNum();
			num2 = inputNum();
			if((num1 >= 20 && num1 < 60) ||(num2 >= 20 && num2 < 60)) {
				count++;
				System.out.println(count);
				break;
			} else {
				System.out.println(count);
				break;
			}
		}
			max = maxValue(num1, num2);
			min = minValue(num1, num2);
			System.out.println("max = " + max + " min = " + min);
			
		while(true) {
			if(num1 >= 1 && num1 <= 20) {
				num2 = num1;
				System.out.println("num1 = " + num1 + " num2 = " +num2);
				break;
			}else {
				break;
			}
		}
	}
	
	public static int inputNum() {
		int num = 0;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("input num : ");
			num = input.nextInt();
			if(num < 1 || num > 100) {
				System.out.print("wrong input number.");
				continue;
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
	
}
