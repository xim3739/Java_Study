package cellPone.app;

public class CellPone {
	String model;
	String color;
	
	void powerOn() {
		System.out.println("ON");
	}
	void powerOff() {
		System.out.println("OFF");
	}
	void bell() {
		System.out.println("Bell");
	}
	void sendVoice(String message) {
		System.out.println("me : " + message);
	}
	void reciveVoice(String message) {
		System.out.println("your : " + message);
	}
	void hangUp() {
		System.out.println("call Off");
	}
}
