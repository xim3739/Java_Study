package book_347;

class Animal {
	void sound() {
		System.out.println("Animal sound()");
	}
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("walwal");
	}
}

class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("yyyyy");
	}
}

public class DynamicCallTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		Animal obj;
		
		obj = animal;
		obj.sound();
		
		obj = dog;
		obj.sound();
		
		obj = cat;
		obj.sound();
	}

}
