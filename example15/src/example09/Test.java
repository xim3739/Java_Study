package example09;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String[] s = {"apple", "banana", "grape"};
		ArrayList list = new ArrayList(Arrays.asList(s));
		//1
		list.add("pear");
		System.out.println(list);
		//2
		list.add(2,"wow");
		System.out.println(list);
		//3
		System.out.println(list.get(3));
		//4
		list.remove(1); System.out.println(list);
		//5
		System.out.println(list.contains("apple"));
		//6
		System.out.println(list.indexOf("wow"));
	}

}
