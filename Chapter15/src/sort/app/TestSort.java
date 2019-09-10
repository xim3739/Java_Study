package sort.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		
		String[] strArray = {"xim", "kim", "seo", "123", "hahah"};
		
		List<String> list = Arrays.asList(strArray);
		
		Collections.sort(list);
		printIter(list);
		
		strArray = (String[])(list.toArray());
		for(String s : strArray) {
			System.out.println(s);
		}
		
	}
	
	public static void printIter(List<String> list) {
		
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
