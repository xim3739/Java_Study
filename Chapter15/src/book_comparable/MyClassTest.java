package book_comparable;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass<MyClass> myClass = new MyClass<MyClass>(10, "xim");
		MyClass<MyClass> myClass2 = new MyClass<MyClass>(20, "seo");
		
		int value = myClass.compareTo(myClass2);
		
		switch (value) {
		case 0:
			System.out.println("eqauls");
			break;
		case 1 :
			System.out.println(myClass.getName() + " is bigger");
			break;
		case -1 :
			System.out.println(myClass2.getName() + " is bigger");
			break;
		}
		
		MyClass[] mcArray = {new MyClass<MyClass>(10, "xim"),new MyClass<MyClass>(30, "seo"),new MyClass<MyClass>(20, "kim"),new MyClass<MyClass>(40, "choi")};
		
		MyClass largeClass = MyArrayAlg.getMax(mcArray);
		
		System.out.println(largeClass.getName() + " is bigger");
		
		String[] strArray = {"xim", "seo", "kim", "choi"};
		String larString = MyArrayAlg.getMax(strArray);
		
		System.out.println(larString + " is bigger");
	}

}
