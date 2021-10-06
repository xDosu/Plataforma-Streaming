package Streaming_Platform;

public class GenereFilter extends Filter{
	private String genere;

	public GenereFilter(String genere) {
		super();
		this.genere = genere;
	}
	
	public boolean find(Film p) {
		return p.containGender(genere);
	}
}
