package Ejercicio_B;

import java.util.ArrayList;

public class AttributeArray extends Attribute{
	private ArrayList<Attribute> attributes;

	public AttributeArray() {
		super();
		this.attributes = new ArrayList<>();
	}
	public void add(Attribute attribute) {
		attributes.add(attribute);
	}
	public String toString() {
		return attributes.toString();
	}
	public boolean contains(Comparable value) {
		for(Attribute attribute : attributes) {
			if(attribute.contains(value)) return true;
		}
		return false;
	}
	public void clear() {
		attributes.clear();
	}

}
