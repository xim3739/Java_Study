package example07;

public class DogTest {

	public static void main(String[] args) {
		Dog myDog = new Dog("진돗개", 1, "black");
		
		myDog.setColor("호랑이 무늬");
		
		myDog.barking();
		myDog.hungry();
		myDog.sleeping();
		
		System.out.println(myDog.toString());

	}

}
