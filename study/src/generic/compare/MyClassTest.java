package generic.compare;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass<MyClass> myClass = new MyClass<MyClass>(10, "xim");
		MyClass<MyClass> myClass2 = new MyClass<MyClass>(20, "seo");
		
		int compareResult = myClass.compareTo(myClass2);
		
		switch (compareResult) {
		case 1 :
			System.out.println(myClass.getName() + " is bigger");
			break;
		case -1 :
			System.out.println(myClass2.getName() + " is bigger");
			break;
		case 0 :
			System.out.println("same value");
			break;
		default:
			System.out.println("wrong input Instance type");
			break;
		}
		
		MyClass[] arrayMyClass = {new MyClass<MyClass>(10, "xim"), new MyClass<MyClass>(20, "seo"), new MyClass<MyClass>(30, "choi"),new MyClass<MyClass>(25, "kim")};
		
		MyClass arrayMyClassResult = MyClassLargest.getMax(arrayMyClass);
		
		System.out.println(arrayMyClassResult.getName() + " is bigger");
	}

}
