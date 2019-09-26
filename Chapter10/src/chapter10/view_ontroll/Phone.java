package chapter10.view_ontroll;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty phoneName;
	private SimpleStringProperty phoneImage;
	
	public Phone(String phoneName, String phoneImage) {
		this.phoneName = new SimpleStringProperty(phoneName);
		this.phoneImage = new SimpleStringProperty(phoneImage);
	}

	public String getPhoneName() {
		return phoneName.get();
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = new SimpleStringProperty(phoneName);
	}

	public String getPhoneImage() {
		return phoneImage.get();
	}

	public void setPhoneImage(String phoneImage) {
		this.phoneImage = new SimpleStringProperty(phoneImage);
	}

	@Override
	public String toString() {
		return "Phone [phoneName=" + phoneName.get() + ", phoneImage=" + phoneImage.get() + "]";
	}
	
	
}
