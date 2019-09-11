package example11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example11 {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		
		arr.add("a");
		arr.add("b");
		arr.add("c");
		arr.add("d");
		arr.add("e");
		
		Iterator<String> iter = arr.iterator();
		System.out.print("[ ");
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.print("]");
	}

}
