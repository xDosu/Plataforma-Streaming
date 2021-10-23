package Ejercicio_B;

public class OrFilter extends Filter{
	private Filter filter1,filter2;

	public OrFilter(Filter filter1, Filter filter2) {
		super();
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	public boolean find(Film f) {
		return (filter1.find(f) || filter2.find(f));
	}
}
