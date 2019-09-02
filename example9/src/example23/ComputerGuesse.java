package example23;

public class ComputerGuesse {
	private int comValue;
	
	public void setComValue() {
		this.comValue = (int) (Math.random() * 3);
	}

	public int getComValue() {
		return comValue;
	}

	public void setComValue(int comValue) {
		this.comValue = comValue;
	}

	@Override
	public String toString() {
		return "ComputerGuesse [comValue=" + comValue + "]";
	}
	
	
}
