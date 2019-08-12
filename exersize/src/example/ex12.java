package example;

import java.util.Scanner;

public class ex12 {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0, num3 = 0;
		
		num1 = inputNum();
		num2 = inputNum();
		num3 = inputNum();
		
		if(num1 < num2) 
			if(num1 < num3) 
				if(num2 < num3) 
					System.out.println(num1+" "+num2+""+num3);
				else 
					System.out.println(num1+" "+num3+" "+num2);
				
			else 
				if(num2 < num1) 
					System.out.println(num3+" "+num2+" "+num1);
				else 
					System.out.println(num3+" "+num1+" "+num2);
			else 
				if(num2 < num3) 
					if(num1 < num3) 
						System.out.println(num2 + " " +num1+" "+num3);
					else 
						System.out.println(num2+" "+num3+" "+num1);
					
				else 
					if(num2 < num1) 
						System.out.println(num3+" "+num2+" "+num1);
					else 
						System.out.println(num3+" "+num1+" "+num2);

	}

	
	public static int inputNum() {

		int num = 0;
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("input num : ");	
			num = input.nextInt();
			if(num < 1 || num > 100) {
				System.out.println("wrong input number.");
			} else {
				break;
			}
		}
		return num;
	}
	
}
