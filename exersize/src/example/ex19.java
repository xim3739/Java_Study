package example;

import java.util.Scanner;

public class ex19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int result = 0;
		num = inputNum();
		if(num <= 0) {
			result = (num*num*num) -(9*num) +2;
		} else {
			result = 7*num + 2;
		}
		System.out.println("result is " + result);
	}
	public static int inputNum() {
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("input num : ");
		num = input.nextInt();
		return num;
	}
}
