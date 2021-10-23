package Ejercicio_B;

public class StringContainsFilter extends DynamicFilter{
	
	private String value;
	
	public StringContainsFilter(String key,String value) {
		super(key);
		this.value = value;
	}
	@Override
	public boolean find(Film f) {
		return f.get(key).contains(value);
	}
}

