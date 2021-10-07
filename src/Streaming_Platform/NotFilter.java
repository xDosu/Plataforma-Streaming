package Streaming_Platform;

public class NotFilter extends Filter{
	private Filter filter;

	public NotFilter(Filter filter) {
		super();
		this.filter = filter;
	}
	public boolean find(Film f) {
		return !filter.find(f);
	}
}
