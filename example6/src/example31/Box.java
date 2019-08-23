package example31;

public class Box {
	private int width;
	private int length;
	private int height;
	private boolean empty;
	
	public Box() {
		this(0,0,0,false);
	}
	public Box(int width, int length, int height, boolean empty) {
		if(empty == true) {
			this.height =height;
			this.length = length;
			this.width = width;
			this.empty = empty;
		}else {
			this.height =height;
			this.length = length;
			this.width = width;
			this.empty = empty;
		}
	}

	@Override
	public String toString() {
		return "Box [width=" + width + ", length=" + length + ", height=" + height + ", empty=" + empty + "]";
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
