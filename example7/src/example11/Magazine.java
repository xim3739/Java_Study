package example11;

public class Magazine extends Book{
	private String realizeDate;
	
	public Magazine() {
		super();
	}

	public Magazine(String name, int pageNum, String author, String realizeDate) {
		super(name, pageNum, author);
		this.realizeDate = realizeDate;
	}

	public String getRealizeDate() {
		return realizeDate;
	}

	public void setRealizeDate(String realizeDate) {
		this.realizeDate = realizeDate;
	}

	@Override
	public String toString() {
		return "Magazine [realizeDate=" + realizeDate + ", getName()=" + getName() + ", getPageNum()=" + getPageNum()
				+ ", getAuthor()=" + getAuthor() + "]";
	}
	
	
	
}
