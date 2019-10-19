package model;

public class GoodsVO {
	
	private String goods;
	private int price;
	
	public GoodsVO(String goods, int price) {
		super();
		this.goods = goods;
		this.price = price;
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

	@Override
	public String toString() {
		return "GoodsVO [goods=" + goods + ", price=" + price + "]";
	}
	
}
