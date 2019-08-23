package studentSystem.app;

import java.util.Arrays;

public class Student {
	
	private int[] score;
	private int sum;
	private double avg;
	private int max;
	private int min;
	
	public Student() {
		this(0);
	}
	public Student(int size) {
		this.score = new int[size];
		this.sum = 0;
		this.avg = 0.0;
		this.max = 0;
		this.min = 0;
	}
	public void inputScore() {
		for(int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random()*100+1);
		}
	}
	public void sumValue() {
		for(int i = 0; i < score.length; i++) {
			this.sum = this.sum + score[i];
		}
		System.out.println("sum is " + this.sum);
	}
	public void avgValue() {
		this.avg = (double)this.sum / (double)this.score.length;
		System.out.println("avg is " + this.avg);
	}
	public void printArray() {
		for(int i = 0; i < score.length; i++) {
			System.out.printf("%2d is %4d \n", i+1, score[i]);
		}
	}
	public void getMax() {
		this.max = this.score[0];
		for(int i = 0; i < this.score.length; i++) {
			if(this.score[i] > this.max) {
				this.max = this.score[i];
			}
		}
		System.out.println("max is " + this.max);
	}
	public void getMin() {
		this.min = this.score[0];
		for(int i = 0; i < this.score.length; i++) {
			if(this.score[i] < this.min) {
				this.min = this.score[i];
			}
		}
		System.out.println("min is " + this.min);
	}
	@Override
	public String toString() {
		return "Student [score=" + Arrays.toString(score) + ", sum=" + sum + ", avg=" + avg + ", max=" + max + ", min="
				+ min + "]";
	}
	
}
