package arrayList.test;

import java.util.ArrayList;
import java.util.Iterator;

public class MyClassTest {

	public static void main(String[] args) {
		ArrayList<MyClass> list = new ArrayList<MyClass>();
		
		list.add(new MyClass(20));
		list.add(new MyClass(10));
		list.add(new MyClass(40));
		list.add(new MyClass(50));
		list.add(new MyClass(270));
		
		Iterator<MyClass> myClassIterator = list.iterator();
		
		while(myClassIterator.hasNext()) {
			System.out.println(myClassIterator.next());
		}
		
	}

}
