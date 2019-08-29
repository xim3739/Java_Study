package example11;

public class Book {
	private String name;
	private int pageNum;
	private String author;
	
	public Book() {
		super();
	}
	
	public Book(String name, int pageNum, String author) {
		this.name = name;
		this.pageNum = pageNum;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", pageNum=" + pageNum + ", author=" + author + "]";
	}
	
	
}
