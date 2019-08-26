package book_325;

class Base {
	public Base() {
		System.out.println("Base()");
	}
}

class Derived extends Base {
	public Derived() {
		System.out.println("Derived()");
	}
}

public class Test {

	public static void main(String[] args) {
		Derived derived = new Derived();
	}

}
