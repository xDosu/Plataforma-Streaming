package Streaming_Platform;

public class ActressFilter extends Filter{
	private String actress;

	public ActressFilter(String actress) {
		super();
		this.actress = actress;
	}
	public boolean find(Film p) {
		return p.containActor(actress);
	}
}
