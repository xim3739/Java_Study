package book_330;

public class ColorRectangle extends Rectangle {
	String color;

	public ColorRectangle(int x, int y, int width, int height, String color) {
		super(x, y, width, height);
		System.out.println("ColoredRectangle()");
		this.color = color;
	}
	
	public static void main(String[] args) {
		ColorRectangle colorRec = new ColorRectangle(10,10,20,20,"red");
	}

}
