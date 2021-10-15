package Streaming_Platform;

import java.util.HashSet;

public class Film {
	private String title,synopsis,director;
	
	private int year,duration,minAge;
	
	HashSet<String> genders = new HashSet<String>();
	HashSet<String> actors = new HashSet<String>();
	
	public Film(String title, String synopsis, String director, int year, int duration, int minAge) {
		super();
		this.title = title;
		this.synopsis = synopsis;
		this.director = director;
		this.year = year;
		this.duration = duration;
		this.minAge = minAge;
	}
	public void addActor(String actor) {
		actors.add(actor.toLowerCase());
	}
	public void addGender(String gender) {
		genders.add(gender.toLowerCase());
	}
	public String getActors() {
		return actors.toString();
	}
	public String getGenders() {
		return genders.toString();
	}
	public String getTitle() {
		return title;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public String getDirector() {
		return director;
	}
	public int getYear() {
		return year;
	}
	public int getDuration() {
		return duration;
	}
	public int getMinAge() {
		return minAge;
	}
	public boolean containActor(String actor) {
		return actors.contains(actor.toLowerCase());
	}
	public boolean containGender(String genero) {
		return genders.contains(genero.toLowerCase());
	}
	public String toString() {
		return "Titulo : " + title + 
				"\nSinopsis : " + synopsis +
				"\nReparto : " + getActors() +
				"\nGenero : " + getGenders() + 
				"\nDirector : " + director;
	}
	public HashSet<Film> find(Filter f){
		HashSet<Film> result = new HashSet<Film>();
		if(f.find(this)) result.add(this);
		return result;
	}
	// Implementar metodo equals
}
