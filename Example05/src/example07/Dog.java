package example07;

public class Dog {
	private String breed;
	private int age;
	private String color;
	
	public Dog() {
		this.age = 0;
		this.breed = null;
		this.color = null;
	}
	
	public Dog(String breed, int age, String color) {
		this.breed = breed;
		this.age = age;
		this.color = color;
	}
	public void barking() {
		System.out.println(this.breed + " is Woop! Woop!");
	}
	public void hungry() {
		System.out.println(this.breed + " is hungry.");
	}
	public void sleeping() {
		System.out.println(this.breed + " is sleeping.");
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [breed=" + breed + ", age=" + age + ", color=" + color + "]";
	}
	
}
