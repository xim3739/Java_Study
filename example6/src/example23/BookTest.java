package example23;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.setAuthor("xim");
		book.setTitle("HIHIHI");
		
		System.out.println("book Name : " + book.getTitle());
		System.out.println("book Author : " + book.getAuthor());
	}

}
