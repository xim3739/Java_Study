package anonemoseInstance;
public class AnimalTest {

	public static void main(String[] args) {
		
		Animal[] arr = {new Bear(),new Dog(),new Lion(), new Animal() {
			@Override
			public void move() {
				System.out.println("cat move");
			}
		}
		};
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].move();
		}
	}

}
