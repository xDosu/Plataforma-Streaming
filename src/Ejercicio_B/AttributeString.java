package Ejercicio_B;

public class AttributeString extends Attribute{
	private String value;
	
	public AttributeString(String valor) {
		this.value = valor;
	}
	@Override
	public Comparable getObjectValue() {
		// TODO Auto-generated method stub
		return value;
	}
	public boolean contains(Comparable sequence){
		return value.contains((CharSequence) sequence);
	}
	public String toString() {
		return value;
	}
}
