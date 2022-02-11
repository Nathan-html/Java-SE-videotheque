package fr.nathan.videotheque.models;

import java.time.LocalDate;

public class Movie extends Media{
	
	private LocalDate releaseDate;
	private Director director;
	private Boolean wasViewed;
	
	public Movie(String title, LocalDate releaseDate, Director director) {
		super(title);
		this.releaseDate = releaseDate;
		this.director = director;
		this.setWasViewed(false);
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
	
    @Override
    public String toString() {
        return  this.superToString().substring(0, this.superToString().length() - 1) +
                ", releaseDate=" + releaseDate +
                ", director" + director +
                ", wasViewed" + wasViewed +
                '}';
    }
}
