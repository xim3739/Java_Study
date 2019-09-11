package example15;

public class Test {

	public static void main(String[] args) {
		Object obj = Example15.a(10.0);
		System.out.println(obj.getClass().getName());
		
		Object obj2 = Example15.a(10);
		System.out.println(obj2.getClass().getName());
	}

}
