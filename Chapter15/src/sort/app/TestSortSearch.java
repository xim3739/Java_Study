package sort.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSortSearch {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < 100; i++) {
			list.add((int) (Math.random() * 100 + 1));
		}
		
		Collections.sort(list);
		
		for(Integer i : list) {
			System.out.print(" " + i);
		}
		long start = System.nanoTime();
		int index = Collections.binarySearch(list, 50);
		long stop = System.nanoTime();
		
		System.out.println("");
		System.out.println(index + " \n"+ (stop - start));
		
	}

}
