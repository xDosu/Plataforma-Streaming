package Ejercicio_B;

public abstract class DynamicFilter extends Filter{
	protected String key;
	
	public DynamicFilter(String key) {
		this.key = key;
	}
	public abstract boolean find(Film f);
}