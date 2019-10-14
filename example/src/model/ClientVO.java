package model;

public class ClientVO {
	private String id;
	private String password;
	private String name;
	private String phone;
	
	public ClientVO(String id, String password, String name, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
