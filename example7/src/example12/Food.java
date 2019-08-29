package example12;

public class Food {
	private int calory;
	private int price;
	private double weight;
	
	public Food() {
		super();
	}

	public Food(int calory, int price, double weight) {
		super();
		this.calory = calory;
		this.price = price;
		this.weight = weight;
	}

	public int getCalory() {
		return calory;
	}

	public void setCalory(int calory) {
		this.calory = calory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Food [calory=" + calory + ", price=" + price + ", weight=" + weight + "]";
	}
	
	
}
