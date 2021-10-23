package Ejercicio_B;

import java.util.HashMap;
import java.util.Map;

public class Film {
	private HashMap<String,Attribute> attributes;
	
	public Film() {
		attributes = new HashMap<String,Attribute>();
	}
	
	public void add(String key, Attribute value) {
		attributes.put(key, value);
	}
	
	public Attribute get(String key) {
		return attributes.get(key);
	}
	public String toString() {
		String toString = "-----------------\n";
		for(Map.Entry<String, Attribute> entry : attributes.entrySet()) {
			toString += entry.getKey() + ": " + entry.getValue().toString() + "\n";
		}
		return toString;
	}
}

