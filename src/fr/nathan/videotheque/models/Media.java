package fr.nathan.videotheque.models;

public abstract class Media {

	private String title;
	
	public Media(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public String superToString() {
		return "{title=" + title + "}";
		
	}
}
