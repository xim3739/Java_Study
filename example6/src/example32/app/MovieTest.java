package example32.app;

public class MovieTest {

	public static void main(String[] args) {
		Movie ximMovie = new Movie();
		ximMovie.setMovieName("arirang");
		System.out.println(ximMovie);
		
		Movie seoMovie = new Movie("seo", "arirang2", "xims");
		System.out.println(seoMovie);
	}

}
