package example16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Example16 {
	public static final int PERSON = 10;
	public static final Scanner SCAN = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Double> score = new ArrayList<Double>();
		for(int i = 0; i < PERSON; i++) {
			System.out.print("심사위원의 점수 : ");
			score.add(SCAN.nextDouble());
		}
		
		Object[] socerArr = score.toArray();
		double sum = 0;
		double avg = 0;
		for(int i = 1; i < socerArr.length-1; i++) {
			sum = sum + (double)socerArr[i];
		}
		
		System.out.println("점수의 합 : " + sum);
	}
	
	

}
