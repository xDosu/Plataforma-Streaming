package Ejercicio_B;

public class AttributeNumber extends Attribute{
	private Comparable value;
	
	public AttributeNumber(Comparable value) {
		super();
		this.value = value;
	}
	@Override
	public Comparable getObjectValue() {
		return value;
	}
	@Override
	public String toString() {
		return value.toString();
	}
	@Override
	public boolean contains(Comparable value) {
		return this.value.equals(value);
	}
	
}
