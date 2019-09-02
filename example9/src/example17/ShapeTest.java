package example17;

public class ShapeTest {

	public static void main(String[] args) {
		Movable[] triMove = {new Triangle(), new Triangle(), new Triangle()};
		for(int i = 0; i < triMove.length; i++) {
			System.out.print((i + 1) + " shape : ");
			triMove[i].move((int)(Math.random() * 10 +1 ), (int)(Math.random() * 10 + 1));
		}
		
		Drawable[] draw = {new Triangle(), new Triangle(), new Triangle()};
		for(int i = 0; i < draw.length; i++) {
			System.out.print((i + 1) + " shape : ");
			draw[i].draw();
		}
	}

}
