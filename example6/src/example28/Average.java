package example28;

import java.util.Scanner;

public class Average {
	private int num1;
	private int num2;
	private int num3;
	
	private double avg;
	
	Scanner scan = new Scanner(System.in);
	
	public Average() {
		this.num1 = 0;
		this.num2 = 0;
		this.avg  = 0.0;
		this.num3 = 0;
	}
	
	public void getAverage(int num1, int num2) {
		avg = (double)(num1 + num2) / 2.0;
		System.out.println(avg);
	}
	public void getAverage(int num1 , int num2, int num3) {
		avg = (double)(num1 + num2 + num3) / 3.0;
		System.out.println(avg);
	}
}
