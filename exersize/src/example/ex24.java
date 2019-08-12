package example;

import java.util.Scanner;

public class ex24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1; int b = 1; int c = 1;
		int i = 0; int num = 0;
		
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		
		for(i = 2; i <= num; i++) {
			c = a+b;
			System.out.println(c);
			a = b;
			b = c;
			
		}
	}

}
