package example06;

class Animal {
	String name;
	public Animal() {
		name = "UNKNOWN";
		System.out.println("animal " + name);
	}
	public Animal(String name) {
		this.name = name;
		System.out.println("animal " + this.name);
	}
}

class Lion extends Animal {
	public Lion() {
		System.out.println("LION");
	}
	public Lion(String name) {
		super(name);
		System.out.println("LION");
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion lion = new Lion("Brave");
		Lion lion2 = new Lion();
	}

}
