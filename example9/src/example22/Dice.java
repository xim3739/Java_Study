package example22;

public class Dice {
	
	private int diceNum;
	
	public Dice() {
		this.diceNum = 1;
	}
	
	public int roll() {
		this.diceNum = (int)(Math.random() * 6 + 1);
		
		return this.diceNum;
	}
	
	public void setValue(int v) {
		this.diceNum = v;
	}
	
	public int getValue() {
		return this.diceNum;
	}

	@Override
	public String toString() {
		return "Dice [diceNum=" + diceNum + "]";
	}
	
	
}
