package hashset;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		hs1.add("111");
		hs1.add("222");
		hs1.add("333");
		hs2.add("111");
		hs2.add("222");
		hs2.add("555");
		
		iteratorPrint(hs1);
		iteratorPrint(hs2);
		
//		hs1.addAll(hs2);
//		iteratorPrint(hs1);

		hs1.retainAll(hs2);
		iteratorPrint(hs1);
		
	}
	
	public static  void iteratorPrint(HashSet<String> hs) {
		System.out.println("=====================");
		
		Iterator<String> iter = hs.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
