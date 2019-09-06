package qeue.test;

import java.util.LinkedList;
import java.util.Queue;

public class TestQeue {
	public static final int SIZE = 10;

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = SIZE; i >= 0; i--) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove() + " ");
			Thread.sleep(1000);
		}
	}

}
