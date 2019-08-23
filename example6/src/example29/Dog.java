package example29;

public class Dog {
	private String name;
	public String breed;
	private int age;
	
	public Dog() {
		this(null, 0);
	}
	public Dog(String name, int age) {
		this(name, null, age);
	}
	public Dog(String name, String breed, int age) {
		this.age = age;
		this.breed = breed;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + ", age=" + age + "]";
	}
	
	
}
