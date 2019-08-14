package Study;

import java.util.Scanner;

public class GCD_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0;
		int num2 = 0;
		int max = 0;
		int min = 0;
		
		num1 = inputNum();
		num2 = inputNum();
		
		max = maxValue(num1, num2);
		min = minValue(num1, num2);
		
		GDC(max, min);
		
	}
	
	public static int inputNum() {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("input num : ");
			num = scan.nextInt();
			if(num < 1 || num > 100) {
				System.out.println("wrong input number.");
				continue;
			} else {
				break;
			}
		}
		return num;
	}
	public static int maxValue(int num1, int num2) {
		int max = 0;
		
		if(num1 >num2) {
			max = num1;
		}else {
			max = num2;
		}
		return max;
	}
	public static int minValue(int num1, int num2) {
		int min = 0;
		
		if(num1 > num2) {
			min = num2;
		}else {
			min = num1;
		}
		return min;
	}
	
	public static void GDC(int max, int min) {
		int result = 0;
		while(true) {
			if(min == 0) {
				System.out.println("GDC is " + max);
				break;
			}else {
				result = max % min;
				max = min;
				min = result;
				continue;
			}
		}
	}
	
}
