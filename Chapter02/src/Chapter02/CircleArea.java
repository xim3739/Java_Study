package Chapter02;

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		final double PI = 3.141592;
		
		double radius = 0.0;
		double area = 0.0;
		
		System.out.print("input radius : ");
		radius = input.nextDouble();
		
		area = PI * radius * radius;
		
		System.out.println(area);
		
	}

}
