package Ejercicio_B;

public class ComparableEqualsFilter extends DynamicFilter{
	private Comparable value;

	public ComparableEqualsFilter(String key,Comparable value) {
		super(key);
		this.value = value;
	}
	@Override
	public boolean find(Film f) {
		return value.compareTo(f.get(key).getObjectValue()) == 0;
	}
}
