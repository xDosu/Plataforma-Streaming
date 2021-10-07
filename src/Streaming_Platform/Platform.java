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
	public void addRule(Filter filter) {
		rules.add(filter);
	}
	public boolean addFilm(Film p) {
		// Se comprueban todas las reglas para poder agregar una Pelicula.
		for(Filter r : rules)
			if(!r.find(p)) return false;
		movies.add(p);
		return true;
	}
	public HashSet<Film> find(Filter filter){
		HashSet<Film> matches = new HashSet<Film>();
		for(Film film : movies) 
			if(filter.find(film)) matches.add(film);
		return matches;
	}
	public boolean esRentable(HashSet<Filter> filters, Film film) {
		for(Filter filter : filters)
			if(!filter.find(film)) return false;
		return true;
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
		Film p3 = new Film("Robots","...","Chris Wedge",2005,91,5);
		Film p4 = new Film("Venom","...","Andy Serkis",2002,119,18);
		
		p1.addActor("Ricardo Darin");
		p1.addActor("Guillermo Francella");
		p2.addActor("Will Smith");
		
		p1.addGender("Drama");
		p1.addGender("Suspenso");
		p2.addGender("Accion");
		p3.addGender("Infantil");
		
		p4.addGender("comedia");
			
		//Inicializacion
		Platform netflix = new Platform("Netflix");
		netflix.addFilm(p1);
		netflix.addFilm(p2);
		netflix.addFilm(p3);
		netflix.addFilm(p4);
		
		//Prueba getmovies()
		System.out.println(netflix.getMovies());
		System.out.println("---------------------");
		
		/*Películas cuya duración sea menor a 120 minutos, que no sean del género “comedia”.*/
		NotFilter f1 = new NotFilter(new GenereFilter("comedia"));
		AndFilter f2 = new AndFilter(f1, new DurationFilter(120));
		HashSet<Film> filmFilter = netflix.find(f2);
		
		for(Film film : filmFilter) {
			System.out.println(film.toString());
		}
		//Películas posteriores del 2017, a no ser que se trate de películas del género “infantil” o “documental”.
		HashSet<Filter> filtrosRentable = new HashSet<Filter>();
		filtrosRentable.add(f1);
		filtrosRentable.add(new NotFilter(new YearFilter(2005)));
		System.out.println(netflix.esRentable(filtrosRentable,p1));
		System.out.println(netflix.esRentable(filtrosRentable,p2));
		System.out.println(netflix.esRentable(filtrosRentable,p3));
		System.out.println(netflix.esRentable(filtrosRentable,p4));
	}

}
