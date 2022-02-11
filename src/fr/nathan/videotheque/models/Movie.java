package fr.nathan.videotheque.models;

import java.time.LocalDate;

public class Movie extends Media{
	
	private LocalDate releaseDate;
	private Director director;
	private Boolean wasViewed;
	
	public Movie(String title, LocalDate releaseDate, Director director, Boolean wasViewed) {
		super(title);
		this.releaseDate = releaseDate;
		this.director = director;
		this.setWasViewed(wasViewed);
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Boolean getWasViewed() {
		return wasViewed;
	}

	public void setWasViewed(Boolean wasViewed) {
		this.wasViewed = wasViewed;
	}
}
