package arrayList.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		MyClass[] mc = {new MyClass(10),new MyClass(20),new MyClass(30)};
		
		List<MyClass> list = Arrays.asList(mc);
		Iterator<MyClass> iter = list.iterator();
		
		while(iter.hasNext()) {
			MyClass mc1 = iter.next();
			System.out.println(mc1.num);
		}
	}

}
