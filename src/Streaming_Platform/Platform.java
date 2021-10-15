package Streaming_Platform;

import java.util.HashSet;

public class Platform {
	
	private String name;
	private HashSet<Film> movies = new HashSet<Film>();
	private Filter rules;
	
	public Platform(String name, Filter rules) {
		super();
		this.name = name;
		this.rules = rules;
	}
	public String getName() {
		return name;
	}
	public void setRule(Filter filter) {
		rules = filter;
	}
	public boolean addFilm(Film p) {
		// Se comprueban todas las reglas para poder agregar una Pelicula.
		if(!rules.find(p)) return false;
		movies.add(p);
		return true;
	}
	public HashSet<Film> find(Filter filter){
		HashSet<Film> matches = new HashSet<Film>();
		for(Film film : movies) 
			if(filter.find(film)) matches.add(film);
		return matches;
	}
	/**
	 * @brief 
	 * @return
	 */
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
		Film p3 = new Film("Robots","...","Chris Wedge",2010,91,5);
		Film p4 = new Film("Venom","...","Andy Serkis",2021,119,18);
		
		p1.addActor("Ricardo Darin");
		p1.addActor("Guillermo Francella");
		p2.addActor("Will Smith");
		
		p1.addGender("Drama");
		p1.addGender("Suspenso");
		p2.addGender("Accion");
		p3.addGender("Infantil");
		
		p4.addGender("comedia");
			
		/*Películas cuya duración sea menor a 120 minutos, que no sean del género “comedia”.*/
		NotFilter f1 = new NotFilter(new GenereFilter("comedia"));
		AndFilter f2 = new AndFilter(f1, new DurationFilter(120));
		//Películas posteriores del 2017, a no ser que se trate de películas del género “infantil” o “documental”.
		NotFilter f3 = new NotFilter(new YearFilter(2005));
		
		//Inicializacion
		Platform netflix = new Platform("Netflix",new AndFilter(f1,f3));
		netflix.addFilm(p1);
		netflix.addFilm(p2);
		netflix.addFilm(p3);
		netflix.addFilm(p4);
		
		//Prueba getmovies()
		System.out.println(netflix.getMovies());
		System.out.println("---------------------");
		
		
		HashSet<Film> filmFilter = netflix.find(f2);
		for(Film film : filmFilter) {
			System.out.println(film.toString());
		}

		
	}

}
