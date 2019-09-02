package example20;

import java.util.Arrays;

public class PersonTest {

	public static void main(String[] args) {
		Person xim = new Person("xim", 175);
	
		Person[] arr = {new Person("seo", 170), new Person("kang", 178), new Person("kim", 177), new Person("choi", 176)};
		
		Arrays.sort(arr);
		
		System.out.println(xim.getMaximum(arr));

	}

}
