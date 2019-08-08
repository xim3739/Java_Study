package Chapter02;

import java.util.Scanner;

public class Box {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double width = 0.0;
		double height = 0.0;
		double area = 0.0;
		double perimeter = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("input width : ");
		width = input.nextDouble();
		
		System.out.print("input height : ");
		height = input.nextDouble();
		
		area = width * height;
		
		perimeter = (width * 2) + (height * 2);
		
		System.out.println("area is " +area);
		System.out.println("perimeter is " + perimeter);
	}

}
