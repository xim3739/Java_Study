package model;

public class Sales_VO {
	// 판매Table
	private String e_no;
	private String st_no; // FK고민
	private int ac_sales_num; // 누적개수
	private int ac_sales_price; // 누적금액
	private String memo; // 메모 (null값 허용)
	private String sales_time;
	private String pro_no; // FK
	private int pro_price; // 상품금액
	private int pro_num; // 상품개수
	private String sales_date; // 입사일_판매날짜(날짜형)

	// 생성자
	

	public Sales_VO() {
		super();
	}
	

	public Sales_VO(int ac_sales_num, int ac_sales_price, String memo, String sales_time, String pro_no, int pro_price,
			int pro_num, String sales_date) {
		super();
		this.ac_sales_num = ac_sales_num;
		this.ac_sales_price = ac_sales_price;
		this.memo = memo;
		this.sales_time = sales_time;
		this.pro_no = pro_no;
		this.pro_price = pro_price;
		this.pro_num = pro_num;
		this.sales_date = sales_date;
	}


	public Sales_VO(int ac_sales_num, int ac_sales_price) {
		super();
		this.ac_sales_num = ac_sales_num;
		this.ac_sales_price = ac_sales_price;
	}



	public Sales_VO(String e_no, String st_no, int ac_sales_num, int ac_sales_price, String memo, String sales_time,
			String pro_no, int pro_price, int pro_num, String sales_date) {
		super();
		this.e_no = e_no;
		this.st_no = st_no;
		this.ac_sales_num = ac_sales_num;
		this.ac_sales_price = ac_sales_price;
		this.memo = memo;
		this.sales_time = sales_time;
		this.pro_no = pro_no;
		this.pro_price = pro_price;
		this.pro_num = pro_num;
		this.sales_date = sales_date;
	}

	public Sales_VO(String e_no, String st_no, int ac_sales_num, int ac_sales_price, String sales_time, String pro_no,
			int pro_price, int pro_num, String sales_date) {
		super();
		this.e_no = e_no;
		this.st_no = st_no;
		this.ac_sales_num = ac_sales_num;
		this.ac_sales_price = ac_sales_price;
		this.sales_time = sales_time;
		this.pro_no = pro_no;
		this.pro_price = pro_price;
		this.pro_num = pro_num;
		this.sales_date = sales_date;
	}

	public String getE_no() {
		return e_no;
	}

	//getset
	public void setE_no(String e_no) {
		this.e_no = e_no;
	}

	public String getSt_no() {
		return st_no;
	}

	public void setSt_no(String st_no) {
		this.st_no = st_no;
	}

	public int getAc_sales_num() {
		return ac_sales_num;
	}

	public void setAc_sales_num(int ac_sales_num) {
		this.ac_sales_num = ac_sales_num;
	}

	public int getAc_sales_price() {
		return ac_sales_price;
	}

	public void setAc_sales_price(int ac_sales_price) {
		this.ac_sales_price = ac_sales_price;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSales_time() {
		return sales_time;
	}

	public void setSales_time(String sales_time) {
		this.sales_time = sales_time;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public String getSales_date() {
		return sales_date;
	}

	public void setSales_date(String sales_date) {
		this.sales_date = sales_date;
	}

	public String getPro_no() {
		return pro_no;
	}

	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	
	
	
}