package example30;

public class Plane {
	private String product;
	private String model;
	private int passinser;
	private static int planes;
	
	public  Plane() {
		this(null, null, 0);
	}
	public Plane(String product, String model, int passinser) {
		this.product = product;
		this.model = model;
		this.passinser = passinser;
		planes++;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPassinser() {
		return passinser;
	}
	public void setPassinser(int passinser) {
		this.passinser = passinser;
	}
	
	public static int getPlanes() {

		return planes;
	}
	@Override
	public String toString() {
		return "Plane [product=" + product + ", model=" + model + ", passinser=" + passinser + "]";
	}
	
	
}
