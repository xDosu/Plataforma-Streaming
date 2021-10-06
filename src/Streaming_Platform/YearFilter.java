package Streaming_Platform;

public class YearFilter {
	private int maxYear;

	public YearFilter(int maxYear) {
		super();
		this.maxYear = maxYear;
	}
	public boolean find(Film p) {
		return (p.getYear() <= maxYear);
	}
}
