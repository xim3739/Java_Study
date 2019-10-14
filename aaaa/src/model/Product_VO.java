package model;

public class Product_VO {

	//필드
	private String pro_no;
	private String pro_name;
	private int pro_price;
	private int pro_num;
	
	//생성자
	public Product_VO(String pro_no, String pro_name, int pro_price, int pro_num) {
		super();
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_num = pro_num;
	}
	public Product_VO(String pro_no, String pro_name, int pro_price) {
		super();
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
	}
	public Product_VO() {
		super();
	}
	
	//getset
	public String getPro_no() {
		return pro_no;
	}
	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public int getPro_num() {
		return pro_num;
	}
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	
	
}
