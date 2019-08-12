package example;

import java.util.Scanner;

public class ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0; int y = 0; int z = 0; int min = 0;
		x = inputNum();
		y = inputNum();
		z = inputNum();
		if(x < z) {
			if(x < y) {
				min = x;
			} else {
				min = y;
			}
		}
		else if(y < z) {
			if(y < x) {
				min = y;
			} else {
				min = x;
			}
		}
		else {
			if(z < y) {
				min = z;
			} else {
				min = y;
			}
		}
		System.out.println("min is " + min);
		
	}
	public static int inputNum() {
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("input num : ");
		num = input.nextInt();
		return num;
	}
}
