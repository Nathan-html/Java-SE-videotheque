package fr.nathan.videotheque.services.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import fr.nathan.videotheque.models.Director;
import fr.nathan.videotheque.models.Movie;

public class MovieData {

	// list movies (all movies)
	private List<Movie> videotheque = new LinkedList<>(); 
	
	private Director jonFavreau = new Director("Jon", "Favreau", LocalDateTime.of(1981, 6, 2, 9, 9));
	
	private Movie ironMan = new Movie("Iron Man", LocalDate.of(2008, 4, 30), jonFavreau);
	private Movie ironMan2 = new Movie("Iron Man 2", LocalDate.of(2018, 8, 10), jonFavreau);
	private Movie ironMan3 = new Movie("Iron Man 3", LocalDate.of(2002, 4, 20), jonFavreau);
	
	public MovieData() {
		videotheque.add(ironMan);
		videotheque.add(ironMan3);
		videotheque.add(ironMan2);
	}
	
	public List<Movie> getVidetheque() {
		return this.videotheque;
	}
}
