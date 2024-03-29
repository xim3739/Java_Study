package vector.test;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<Object> vc = new Vector<Object>();
		
		MyClass my = new MyClass(20);
		vc.add("ximximhae");
		vc.add(200);
		vc.add(my);
		
		Iterator<Object> iter = vc.iterator();
		while(iter.hasNext()) {
			Object ob = iter.next();
			if(ob instanceof MyClass) {
				MyClass mc = (MyClass)ob;
				System.out.println(mc.number);
			}
			System.out.println(ob);
		}
		
		for(int i = 0; i < vc.size(); i++) {
			System.out.println(vc.get(i));
		}
		
		for(Object o : vc) {
			System.out.println(o);
		}
		
		vc.remove(1);
		for(Object o : vc) {
			System.out.println(o);
		}
		
		vc.remove(my);
		
		for(Object o : vc) {
			System.out.println(o);
		}
		
		vc.add(1, "Hello");
		for(Object o : vc) {
			System.out.println(o);
		}
	}

}
