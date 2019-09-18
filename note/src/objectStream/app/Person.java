package objectStream.app;

import java.io.Serializable;

public class Person implements Serializable{
	private String adrress;
	private String years;
	private String name;
	
	public Person(String adrress, String years, String name) {
		super();
		this.adrress = adrress;
		this.years = years;
		this.name = name;
	}

	public String getAdrress() {
		return adrress;
	}

	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DataClass [adrress=" + adrress + ", years=" + years + ", name=" + name + "]";
	}
	
	
}
