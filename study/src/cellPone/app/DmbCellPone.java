package cellPone.app;

public class DmbCellPone extends CellPone {
	int channel;
	
	public DmbCellPone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	void turnOnDmb() {
		System.out.println("channel : " + channel + "show time");
	}
	void changeCannelDmb(int channel) {
		this.channel = channel;
		System.out.println("change channel : " + this.channel);
	}
	void turnOffDmb() {
		System.out.println("turn Off Dmb");
	}
}
