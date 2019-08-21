package example19;

public class CheckId {
	public static final String ID = "show11106";
	
	private String inputId;
	
	public CheckId() {
		this.inputId = null;
	}
	public CheckId(String inputId) {
		this.inputId = inputId;
	}
	
	public void checkId() {
		if(inputId.equals(ID)) {
			System.out.println("Check your Id !!");
		} else {
			System.out.println("Worng your Id !!");
		}
	}

}
