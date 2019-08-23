package example32.app;

public class Movie {
	private String movieName;
	private String derecName;
	private String consumer;
	
	public Movie() {
		this(null, null, null);
	}
	public Movie(String movieName, String derecName, String consumer) {
		this.consumer = consumer;
		this.derecName = derecName;
		this.movieName = movieName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDerecName() {
		return derecName;
	}
	public void setDerecName(String derecName) {
		this.derecName = derecName;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", derecName=" + derecName + ", consumer=" + consumer + "]";
	}
	
	
}
