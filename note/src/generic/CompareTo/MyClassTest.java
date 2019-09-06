package generic.CompareTo;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass[] myClass = {new MyClass(10, "xim"),new MyClass(30, "kim"),new MyClass(20, "seo"),new MyClass(5, "choi")};
		
		MyClass myClassResult = MyMethod.getMax(myClass);
		
		System.out.println(myClassResult.getName() + " is bigger");
	}

}
