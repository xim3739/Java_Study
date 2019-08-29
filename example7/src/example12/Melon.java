package example12;

public class Melon extends Food{
	private String productLocation;
	
	public Melon() {
		super();
	}

	public Melon(int calory, int price, double weight, String productLocation) {
		super(calory, price, weight);
		this.productLocation = productLocation;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	@Override
	public String toString() {
		return "Melon [productLocation=" + productLocation + ", getCalory()=" + getCalory() + ", getPrice()="
				+ getPrice() + ", getWeight()=" + getWeight() + "]";
	}

	
	
	
}
