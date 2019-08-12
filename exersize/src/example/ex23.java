package example;

import java.util.Scanner;

public class ex23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0; int num2 = 0; int num3 = 0;
		char calName = 0;
		num1 = inputNum();
		calName = calResult();
		num2 = inputNum();
		
		switch (calName) {
		case '+':
			plus(num1, num2);
			break;
		case '-':
			minus(num1, num2);
			break;
		case '*':
			multy(num1, num2);
			break;
		case '/':
			divide(num1, num2);
			break;
		}
		
	}
	public static char calResult() {
		String calName = null;
		char calValue = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("input cal : ");
		calName = input.next();
		calValue = calName.charAt(0);
		return calValue;
	}
	public static int inputNum() {
		int num = 0 ;
		Scanner input = new Scanner(System.in);
		System.out.print("input number : ");
		num = input.nextInt();
		return num;
	}
	public static void plus(int num1, int num2) {
		System.out.println(num1+" + " +num2 + " = " + (num1+num2));
	}
	public static void minus(int num1, int num2) {
		System.out.println(num1+" - " +num2 + " = " + (num1-num2));
	}
	public static void multy(int num1, int num2) {
		System.out.println(num1+" * " +num2 + " = " + (num1*num2));
	}
	public static void divide(int num1, int num2) {
		if(num1 > num2) {
			System.out.println(num1+" * " +num2 + " = " + (num1*num2));
		}else {
			System.out.println("wrong input number.");
		}
	}
}
