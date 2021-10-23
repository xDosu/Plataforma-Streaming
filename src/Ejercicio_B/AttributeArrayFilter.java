package Ejercicio_B;

import java.util.ArrayList;

public class AttributeArrayFilter extends DynamicFilter{
	private Comparable value;

	public AttributeArrayFilter(String key, Comparable value) {
		super(key);
		this.value = value;
	}

	@Override
	public boolean find(Film f) {
		return f.get(key).contains(value);
	}
	
}
