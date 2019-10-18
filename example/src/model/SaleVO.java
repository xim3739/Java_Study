package model;

public class SaleVO {
	
	private String date;
	private String goods;
	private int price;
	private int count;
	private int total;
	private String coments;
	
	public SaleVO(String date, String goods, int price, int count, int total, String coments) {
		super();
		this.date = date;
		this.goods = goods;
		this.price = price;
		this.count = count;
		this.total = total;
		this.coments = coments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getComents() {
		return coments;
	}

	public void setComents(String coments) {
		this.coments = coments;
	}

	@Override
	public String toString() {
		return "SaleVO [date=" + date + ", goods=" + goods + ", price=" + price + ", count=" + count + ", total="
				+ total + ", coments=" + coments + "]";
	}
	
	
	
}
