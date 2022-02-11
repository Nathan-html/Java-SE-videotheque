package fr.nathan.videotheque.models;

import java.time.LocalDateTime;

public class Director {
	
	private String firstName;
	private String lastName;
	private LocalDateTime birthAt;
	
	public Director(String firstName, String lastName, LocalDateTime birthAt) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthAt(birthAt);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getBirthAt() {
		return birthAt;
	}

	public void setBirthAt(LocalDateTime birthAt) {
		this.birthAt = birthAt;
	}
}
