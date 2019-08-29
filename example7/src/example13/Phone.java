package example13;

public class Phone {
	private String product;
	private int price;
	private String type;
	
	public Phone() {
		super();
	}
	public Phone(String product, int price, String type) {
		this.product = product;
		this.price = price;
		this.type = type;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Phone [product=" + product + ", price=" + price + ", type=" + type + "]";
	}
	
	
}
