package example;

import java.util.Scanner;

public class ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double height = 0.0;
		double weight = 0.0;
		double result = 0.0;
		
		height = inputHeight();
		weight = inputWeight();
		
		result = (height - 100) * 0.9;
		
		System.out.println(result);
		
		if(weight < result) {
			System.out.println("저체중");
		} else if(weight == result) {
			System.out.println("적당");
		} else {
			System.out.println("과체중");
		}
		
		
		
	}
	public static double inputWeight() {
		double weight = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.print("input weight : ");
		weight = input.nextDouble();
		return weight;
	}
	
	public static double inputHeight() {
		double height = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.print("input height : ");
		height = input.nextDouble();
		return height;
	}
}
