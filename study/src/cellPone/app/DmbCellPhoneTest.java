package cellPone.app;

public class DmbCellPhoneTest {

	public static void main(String[] args) {
		DmbCellPone dmbCellPone = new DmbCellPone("Java", "black", 10);
		
		System.out.println("model : " + dmbCellPone.model);
		System.out.println("color : " + dmbCellPone.color);
		
		System.out.println("channel : " + dmbCellPone.channel);
		
		dmbCellPone.powerOn();
		dmbCellPone.bell();
		dmbCellPone.sendVoice("hi");
		dmbCellPone.reciveVoice("Oh hi");
		dmbCellPone.hangUp();
		
		dmbCellPone.turnOnDmb();
		dmbCellPone.changeCannelDmb(20);
		dmbCellPone.turnOffDmb();
	}

}
