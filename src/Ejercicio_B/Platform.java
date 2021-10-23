package Ejercicio_B;

import java.util.HashSet;

public class Platform {
	
	private String name;
	private HashSet<Film> movies = new HashSet<Film>();
	private Filter rules;
	
	public Platform(String name) {
		super();
		this.name = name;
	}
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
		//if(!rules.find(p)) return false;
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
	public String toString() {
		String total = "Todas las peliculas (" + movies.size() + "): \n-------------------------\n";
		for(Film p : movies) {
			total += p.toString() + "\n";
		}
		total += "-------------------------";
		return total;
	}
	public static void main(String[] args) {
//		p1.addActor("Ricardo Darin");
//		p1.addActor("Guillermo Francella");
//		p2.addActor("Will Smith");
//		
//		p1.addGender("Drama");
//		p1.addGender("Suspenso");
//		p2.addGender("Accion");
//		p3.addGender("Infantil");
//		
//		p4.addGender("comedia");
		
		// Creacion de arreglo de atributos
		AttributeArray actoresf1,actoresf2,actoresf3,actoresf4;
		AttributeArray gendersf1,gendersf2,gendersf3,gendersf4;
		actoresf1 = new AttributeArray();
		actoresf2 = new AttributeArray();
		actoresf3 = new AttributeArray();
		actoresf4 = new AttributeArray();
		
		AttributeArray puntajes = new AttributeArray();
		gendersf1 = new AttributeArray();
		gendersf2 = new AttributeArray();
		gendersf3 = new AttributeArray();
		gendersf4 = new AttributeArray();
		
		puntajes.add(new AttributeNumber(5));
		puntajes.add(new AttributeNumber(10));
		
		/*
		System.out.println(actores.toString());
		System.out.println(genders.toString());
		System.out.println(puntajes.toString());
		*/
		
		
		// Creacion de peliculas
		Film f1 = new Film();
		f1.add("titulo", new AttributeString("El secreto de sus ojos"));
		f1.add("director", new AttributeString("Campanella"));
		f1.add("anio", new AttributeNumber(2004));
		f1.add("duracion", new AttributeNumber(110));
		f1.add("edadMinima", new AttributeNumber(18));
		actoresf1.add(new AttributeString("Ricardo Darin"));
		actoresf1.add(new AttributeString("Guillermo Francella"));
		gendersf1.add(new AttributeString("Drama"));
		f1.add("actores", actoresf1);
		f1.add("generos", gendersf1);
		f1.add("puntuaciones", puntajes);
		
		Film f2 = new Film();
		f2.add("titulo", new AttributeString("Yo Robot"));
		f2.add("director", new AttributeString("Alex Proyas"));
		f2.add("anio", new AttributeNumber(2004));
		f2.add("duracion", new AttributeNumber(121));
		f2.add("edadMinima", new AttributeNumber(15));
		actoresf2.add(new AttributeString("Will Smith"));
		gendersf2.add(new AttributeString("Accion"));
		f2.add("actores", actoresf2);
		f2.add("generos", gendersf2);
		f2.add("puntuaciones", puntajes);
		
		Film f3 = new Film();
		f3.add("titulo", new AttributeString("Robots"));
		f3.add("director", new AttributeString("Chris Wedge"));
		f3.add("anio", new AttributeNumber(2010));
		f3.add("duracion", new AttributeNumber(150));
		f3.add("edadMinima", new AttributeNumber(5));
		actoresf3.add(new AttributeString("Ewan McGregor"));
		gendersf3.add(new AttributeString("Infantil"));
		f3.add("actores", actoresf3);
		f3.add("generos", gendersf3);
		f3.add("puntuaciones", puntajes);
		
		Film f4 = new Film();
		f4.add("titulo", new AttributeString("Venom"));
		f4.add("director", new AttributeString("Andy Serkis"));
		f4.add("anio", new AttributeNumber(2021));
		f4.add("duracion", new AttributeNumber(119));
		f4.add("edadMinima", new AttributeNumber(18));
		actoresf4.add(new AttributeString("Tom Hardy"));
		gendersf4.add(new AttributeString("Accion"));
		f4.add("actores", actoresf4);
		f4.add("generos", gendersf4);
		f4.add("puntuaciones", puntajes);
				
		// Creacion Filtros
		
		/*
		DynamicFilter filter1 = new ComparableEqualsFilter("director","Campanella"); // Tiene que dar TRUE
		DynamicFilter filter2 = new ComparableLessEqualFilter("anio",2020); // Tiene que dar FALSE
		DynamicFilter filter3 = new ComparableHigherEqualFilter("duracion",109); // Tiene que dar FALSE
		DynamicFilter filter4 = new StringContainsFilter("titulo","secreto"); // Tiene que dar TRUE
		DynamicFilter filter5 = new AttributeArrayFilter("actores","Ricardo Darin"); // Tiene que dar TRUE
		DynamicFilter filter6 = new AttributeArrayFilter("puntuaciones",6); // Tiene que dar FALSE
		DynamicFilter filter7 = new AttributeArrayFilter("puntuaciones",10); // Tiene que dar TRUE


		System.out.println(filter1.find(f1));
		System.out.println(filter2.find(f1));
		System.out.println(filter3.find(f1));
		System.out.println(filter4.find(f1));
		System.out.println(filter5.find(f1));
		System.out.println(filter6.find(f1));
		System.out.println(filter7.find(f1));
		*/
		
		
		// Creacion Plataforma
		Platform netflix = new Platform("Netflix");
		netflix.addFilm(f1);
		netflix.addFilm(f2);
		netflix.addFilm(f3);
		netflix.addFilm(f4);
	
		
		// Filtros
		
		/*Películas cuya duración sea menor a 120 minutos, que no sean del género “comedia”.*/
		NotFilter filter1 = new NotFilter(new AttributeArrayFilter("generos","Comedia"));
		DynamicFilter filter2 = new ComparableLessEqualFilter("duracion",120);
		AndFilter filter3 = new AndFilter(filter1, filter2);
		
		/*Películas posteriores del 2017, a no ser que se trate de películas del género “infantil” o “documental”.*/
		DynamicFilter filter5 = new ComparableHigherEqualFilter("anio",2017);
		DynamicFilter filter6 = new AttributeArrayFilter("generos","Infantil");
		DynamicFilter filter7 = new AttributeArrayFilter("generos","documental");
		OrFilter filter8 = new OrFilter(filter5, new OrFilter(filter6,filter7));
		
		
		HashSet<Film> filmFilter = netflix.find(filter8);
		for(Film film : filmFilter) {
			System.out.println(film.toString());
		}		
	}

}
