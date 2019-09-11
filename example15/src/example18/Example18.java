package example18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Example18 {
	
	public static final int SIZE = 10;

	public static void main(String[] args) {
		HashSet<Integer> rotto = new HashSet<Integer>();
//		while(true) {
//			if(rotto.size() != SIZE) {
//				rotto.add((int)(Math.random() * 45 + 1));		
//			} else {
//				break;
//			}
//		}
		
		while(true) {
			int num = (int)(Math.random() * 45 + 1);
			if(!rotto.contains(num)) {
				rotto.add(num);
			}
			if(rotto.size() == 6) {
				break;
			}
		}

		Iterator<Integer> iter = rotto.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
