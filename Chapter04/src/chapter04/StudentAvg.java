package chapter04;

import java.util.Arrays;
import java.util.Scanner;

public class StudentAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int STUDENT = 10;
		
		int total = 0;
		
		int [] score = new int[] {10, 20, 30, 40, 50};
		//int [] score = {10, 20, 30, 40, 50};
		
		for(int i = 0; i < score.length; i++) {
			//score[i] = (int)(Math.random() * (100 - 50 + 1) + 50);
			total = score[i] + total;
		}
		
		System.out.println(Arrays.toString(score));
		System.out.println("Score avg is " + ((double)total/(double)score.length));
	}

}
