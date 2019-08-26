package example24;

public class Dice {
	private int diceNum;
	
	public Dice() {
		this.diceNum = 0;
	}
	
	public int roll() {
		this.diceNum = (int)((Math.random() * 6 )+ 1);
		return this.diceNum;
	}
	
}
