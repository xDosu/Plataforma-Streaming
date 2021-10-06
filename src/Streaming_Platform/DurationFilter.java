package Streaming_Platform;

public class DurationFilter {
	private int maxDuration;
	public DurationFilter(int maxDuration) {
		super();
		this.maxDuration = maxDuration;
	}
	public boolean find(Film p) {
		return (p.getDuration() <= maxDuration);
	}
	
}
