package compareable.app;

public class Rectangle implements Compareable {

	private int width;
	private int heigh;
	
	public Rectangle(int width, int heigh) {
		super();
		this.width = width;
		this.heigh = heigh;
	}
	
	
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", heigh=" + heigh + "]";
	}



	@Override
	public int compareTo(Object obj) {
		Rectangle compareRec = null;
		int compareResult = 0;
		
		if(obj instanceof Rectangle) {
			compareRec = (Rectangle)obj;
			if(this.width > compareRec.width) {
				compareResult = 1;
			} else if(this.width < compareRec.width) {
				compareResult = -1;
			} else
				compareResult = 0;
		}
		return compareResult;
	}

}
