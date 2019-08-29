package example13;

public class SmartPhone extends Phone{
	private String osType;
	private String osVersion;
	private int innerRamSize;
	private boolean camera;
	private boolean blueth;
	
	public SmartPhone() {
		super();
	}
	public SmartPhone(String product, int price, String type, String osType, String osVersion, int innerRamSize,
			boolean camera, boolean blueth) {
		super(product, price, type);
		this.osType = osType;
		this.osVersion = osVersion;
		this.innerRamSize = innerRamSize;
		this.camera = camera;
		this.blueth = blueth;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public int getInnerRamSize() {
		return innerRamSize;
	}
	public void setInnerRamSize(int innerRamSize) {
		this.innerRamSize = innerRamSize;
	}
	public boolean isCamera() {
		return camera;
	}
	public void setCamera(boolean camera) {
		this.camera = camera;
	}
	public boolean isBlueth() {
		return blueth;
	}
	public void setBlueth(boolean blueth) {
		this.blueth = blueth;
	}
	@Override
	public String toString() {
		return "SmartPhone [osType=" + osType + ", osVersion=" + osVersion + ", innerRamSize=" + innerRamSize
				+ ", camera=" + camera + ", blueth=" + blueth + ", getProduct()=" + getProduct() + ", getPrice()="
				+ getPrice() + ", getType()=" + getType() + "]";
	}
	
	
}
