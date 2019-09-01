package example06;

public class Rectangle implements GraphicsObject {
	private int lenght;
	private int width;
	
	public void setDimensions(int l, int w) {
		this.lenght = l;
		this.width = w;
	}
	@Override
	public int getArea() {
		return lenght * width;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("lenght is " + lenght + " width is " + width);
	}

}
