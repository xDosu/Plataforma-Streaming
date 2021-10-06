package Streaming_Platform;

import java.util.HashSet;

public class Platform {
	
	private String name;
	private HashSet<Film> movies = new HashSet<Film>();
	private HashSet<Filter> rules = new HashSet<Filter>();
	
	public Platform(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean addFilm(Film p) {
		// Se comprueban todas las reglas para poder agregar una Pelicula.
		for(Filter r : rules)
			if(!r.find(p)) return false;
		movies.add(p);
		return true;
	}
	public String getMovies() {
		String total = "Todas las peliculas (" + movies.size() + "): \n-------------------------\n";
		for(Film p : movies) {
			total += p.getTitle() + "\n";
		}
		total += "-------------------------";
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creacion de movies
		Film p1 = new Film("El secreto de sus ojos","..." ,"Campanella", 2009, 129, 18);
		Film p2 = new Film("Yo Robot","...","Alex Proyas",2004,115,15);
		Film p3 = new Film("Robots","...","Chris Wedge",2005,91,5);
		
		p1.addActor("Ricardo Darin");
		p1.addActor("Guillermo Francella");
		p2.addActor("Will Smith");
		
		p1.addGender("Drama");
		p1.addGender("Suspenso");
		p2.addGender("Accion");
		p3.addGender("Infantil");
			
		//Inicializacion
		Platform netflix = new Platform("Netflix");
		netflix.addFilm(p1);
		netflix.addFilm(p2);
		netflix.addFilm(p3);
		
		//Prueba getmovies()
		System.out.println(netflix.getMovies());
		System.out.println(p1.toString());
	}

}
