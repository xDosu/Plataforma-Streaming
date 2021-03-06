package Streaming_Platform;

public class DirectorFilter extends Filter{
	private String director;

	public DirectorFilter(String director) {
		super();
		this.director = director;
	}
	public boolean find(Film p) {
		return p.getDirector().equalsIgnoreCase(director);
	}
}
