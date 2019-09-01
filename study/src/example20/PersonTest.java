package example20;

public class PersonTest {

	public static void main(String[] args) {
		Person xim = new Person("xim", 150);
	
		Person[] arr = {new Person("seo", 170), new Person("kang", 180)};
		
		System.out.println(xim.getMaximum(arr));

	}

}
