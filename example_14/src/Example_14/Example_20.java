package Example_14;

import java.util.Scanner;

public class Example_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int studentNum = 0;
		int studentScore = 0;
		int sum = 0;
		double avg = 0.0;
		
		System.out.print("input student number : ");
		studentNum = scanner.nextInt();
		
		int[] score = new int[studentNum];
		
		for(int i = 0; i < score.length; i++) {
			System.out.print("input "+ (i+1) + "student score : ");
			studentScore = scanner.nextInt();
			if(studentScore < 1 || studentScore > 100) {
				System.out.println("wrong input score.");
				i--;
				continue;
			}else {
				score[i] = studentScore;
			}
		}
		for(int i = 0; i < score.length; i++) {
			sum = sum + score[i];
		}
		avg = (double)sum / (double)score.length;
		
		System.out.println("avg is " + avg);
	}

}
