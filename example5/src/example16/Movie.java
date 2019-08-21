package example16;

public class Movie {
	private String movieName;
	private double score;
	private String name;
	private int year;
	
	public Movie() {
		this.movieName = null;
		this.name = null;
		this.score = 0.0;
		this.year = 0;
	}
	public Movie(String movieName, double socre, String name, int year) {
		this.movieName = movieName;
		this.name = name;
		this.score = socre;
		this.year = year;
	}
	
	public void print() {
		System.out.println("movie name is " + this.movieName);
		System.out.println("movie score is " + this.score);
		System.out.println("movie director is " + this.name);
		System.out.println("movie year is " + this.year);
	}
}
