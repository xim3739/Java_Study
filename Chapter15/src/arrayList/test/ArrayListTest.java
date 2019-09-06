package arrayList.test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("apple");
		list.add("grape");
		list.add("milk");
		list.add(1, "pear");
		list.remove("apple");
		list.add("apple");
		
		int j = 0;
		for(String st : list) {
			System.out.println((j++) + " : " + st);
		}
		
		System.out.println("==========");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " : " + list.get(i));
		}
		
		System.out.println("==========");
		
		String s = null;
		Iterator<String> e = list.iterator();
		
		int i = 0;
		
		while(e.hasNext()) {
			
			s = (String)e.next();
			System.out.println(i + " : " + s);
			i++;
		}
		
		}

}
