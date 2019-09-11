package example10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example10 {

	public static void main(String[] args) {
		List<Double> arr = new ArrayList<Double>();
		arr.add(10.0);
		arr.add(23.0);
		arr.add(44.0);
		arr.add(11.0);
		arr.add(22.0);
		
		arr.sort(null);
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println("===========");
		for(Double i : arr) {
			System.out.println(i);
		}
		System.out.println("===========");
		Iterator<Double> iter = arr.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
