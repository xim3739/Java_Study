package chapter10.table_view.test;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty phoneName;
	private SimpleStringProperty PhoneImage;
	
	public Phone(String phoneName, String image) {
		this.phoneName = new SimpleStringProperty(phoneName);
		this.PhoneImage = new SimpleStringProperty(image);
	}

	public String getPhoneName() {
		return phoneName.get();
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = new SimpleStringProperty(phoneName);
	}

	public String getImage() {
		return PhoneImage.get();
	}

	public void setImage(String image) {
		this.PhoneImage = new SimpleStringProperty(image);
	}

	@Override
	public String toString() {
		return "Phone [phoneName=" + phoneName.get() + ", image=" + PhoneImage.get() + "]";
	}
	
	
	
}
