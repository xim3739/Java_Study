package compareToTest;

public class Rectangle implements Compareable{
	public int width;
	public int height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	public int getArea() {
		return this.width * this.height;
	}
	
	@Override
	public int compareTo(Object obj) {
		
		Rectangle compareRec = null;
		Circle circle = null;
		
		int returnValue = 0;
		
		if(obj instanceof Rectangle) {
			compareRec = (Rectangle)obj;
			
			if(this.getArea() < compareRec.getArea()) {
				returnValue = -1;
			} else if (this.getArea() > compareRec.getArea()) {
				returnValue = 1;
			}
			else {
				returnValue = 0;
			}
			
		} else if(obj instanceof Circle) {
			circle = (Circle)obj;
			
			if(this.getArea() < circle.getArea()) {
				returnValue = -1;
			} else if (this.getArea() > circle.getArea()) {
				returnValue = 1;
			}
			else {
				returnValue = 0;
			}
		}
		
		return returnValue;
		
	}
	
}
