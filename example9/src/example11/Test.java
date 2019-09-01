package example11;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point2D p = new Point3D();
		Point3D p1 = (Point3D) (new Point2D());
		
		p.setX(100);
		((Point3D) p).setZ(40);
		
		p1.setZ(10);
		System.out.println(p1.getZ());
	
	}

}
