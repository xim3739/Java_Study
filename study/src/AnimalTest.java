
public class AnimalTest {

	public static void main(String[] args) {
		
		Animal[] arr = {new Bear(),new Dog(),new Lion()};
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].move();
		}
	}

}
