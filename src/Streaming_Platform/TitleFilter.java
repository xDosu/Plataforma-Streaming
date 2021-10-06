package Streaming_Platform;

public class TitleFilter extends Filter{
	private String title;
	
	public TitleFilter(String title) {
		super();
		this.title = title;
	}
	public boolean find(Film p){
		return p.getTitle().toLowerCase().contains(title.toLowerCase());
	}
}
