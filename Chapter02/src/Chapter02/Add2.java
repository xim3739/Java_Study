package Chapter02;

import java.util.Scanner;

public class Add2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int sum = 0;
		
		System.out.print("input first number : ");
		x = input.nextInt();
		
		System.out.print("input second number : ");
		y = input.nextInt();
		
		sum = x + y;
		
		System.out.println("result is " + sum);
	}

}
