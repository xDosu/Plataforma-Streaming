package Ejercicio_B;

public class ComparableLessEqualFilter extends DynamicFilter{
	private Comparable value;

	public ComparableLessEqualFilter(String key,Comparable value) {
		super(key);
		this.value = value;
	}
	@Override
	public boolean find(Film f) {
		return value.compareTo(f.get(key).getObjectValue()) >= 0;
	}

}
