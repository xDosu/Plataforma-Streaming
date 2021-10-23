package Ejercicio_B;

public class ComparableHigherEqualFilter extends DynamicFilter{
	private Comparable value;
	
	public ComparableHigherEqualFilter(String key,Comparable value) {
		super(key);
		this.value = value;
	}

	@Override
	public boolean find(Film f) {
		return value.compareTo(f.get(key).getObjectValue()) <= 0;
	}
	

}
