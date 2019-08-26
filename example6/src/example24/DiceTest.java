package example24;

public class DiceTest {

	public static void main(String[] args) {
		Dice myDice = new Dice();
		
		for(int i = 1; i <= 5; i++) {
			System.out.println(i +" dice : " + myDice.roll());	
		}
		
	}

}
