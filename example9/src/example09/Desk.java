package example09;

public class Desk implements Moveable{
	@Override
	public void A() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Desk desk = new Desk();
		Moveable m = desk;
		desk = (Desk) m;	
	}
}
