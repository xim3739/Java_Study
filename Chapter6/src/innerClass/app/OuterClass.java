package innerClass.app;

public class OuterClass {
	private int age;
	private static int sAge;
	private String name;
	private static String sName;
	private int birth;
	private static int sBirth;
	
	static class InnerClass1 {
		public InnerClass1() {
			sAge = 26;
			sName = "seo";
			sBirth = 1111;
		}
		public void myMethod1() {
			System.out.println("name is " + sName);
			System.out.println("age is " + sAge);
			System.out.println("birthDay is " + sBirth);
		}
	}
	
	class InnerClass2 {
		public InnerClass2() {
			age = 29;
			name = "xim";
			birth = 1106;
			InnerClass1 inner1 = new InnerClass1();
		}
		public void myMethod2() {
			System.out.println("name is " + name);
			System.out.println("age is " + age);
			System.out.println("birthDay is " + birth);
		}
	}
	
	public OuterClass() {
		this(0,null,0);
	}
	
	public OuterClass(int age, String name, int birth) {
	
		InnerClass2 inner2 = new InnerClass2();

	}
	

}
