package fr.nathan.videotheque.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import fr.nathan.videotheque.models.Director;
import fr.nathan.videotheque.models.Movie;
import fr.nathan.videotheque.services.data.MovieData;
import fr.nathan.videotheque.services.menu.VideothequeMenu;
import fr.nathan.videotheque.utils.ConsoleManager;

public class VideothequeApp{

	private List<Movie> data = new MovieData().getVidetheque();
	
	public void run() {
		chooseAction();
	}
	
	private void printMenu(VideothequeMenu[] menu) {
		for (VideothequeMenu item : menu) {
			ConsoleManager.getInstance().printToConsole(item.toString(), true);
		}
	}
	
	private void printList(List<Movie> movies, Boolean option) {
		ConsoleManager.getInstance().printLine();
		list(movies, option);
		ConsoleManager.getInstance().printLine();
	}
	
	private void printListView(List<Movie> movies, Boolean option, Boolean view) {
		ConsoleManager.getInstance().printLine();
		listView(movies, option, view);
		ConsoleManager.getInstance().printLine();
	}
	
	private Boolean handleMenuReq(VideothequeMenu[] menu, int req) {
		if ( req < 0 || req >= menu.length ) {
			return false;
		}
		if ( req < menu.length && req >= 0) {
			return true;
		}
		else { return false; }
	}
	
	private void list(List<Movie> movies, Boolean option) {
		if (!movies.isEmpty()) {
			int id = 1;
			for (Movie movie : movies) {
				if (option) {
					ConsoleManager.getInstance().printToConsole(id + " - " + movie.toString(), true);
					id++;
				}
				if(!option) {
					ConsoleManager.getInstance().printToConsole("> " + movie.toString(), true);
				}
			}
		} else {
			ConsoleManager.getInstance().printToConsole("Aucun film n'a été trouvée", true);
		}
	}
	
	private void listView(List<Movie> movies, Boolean option, Boolean view) {
		if (!movies.isEmpty()) {
			int id = 1;
			for (Movie movie : movies) {
				if (view) {
					if (option && movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole(id + " - " + movie.toString(), true);
						id++;
					}
					if(!option && movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole("> " + movie.toString(), true);
					}
				} else {
					if (option && !movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole(id + " - " + movie.toString(), true);
						id++;
					}
					if(!option && !movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole("> " + movie.toString(), true);
					}
				}
			}
		} else {
			ConsoleManager.getInstance().printToConsole("Aucun film n'a été trouvée", true);
		}
	}
	
	private void addMovie(List<Movie> movies) {
		
		String title = ConsoleManager.getInstance().readUserInput();
		
		int yearRelease = ConsoleManager.getInstance().readUserInputInteger();
		int mouthRelease = ConsoleManager.getInstance().readUserInputInteger();
		int dayRelease = ConsoleManager.getInstance().readUserInputInteger();
		
		String firstName = ConsoleManager.getInstance().readUserInput();
		String lastName = ConsoleManager.getInstance().readUserInput();
		
		int yearDirector = ConsoleManager.getInstance().readUserInputInteger();
		int mouthDirector = ConsoleManager.getInstance().readUserInputInteger();
		int dayDirector = ConsoleManager.getInstance().readUserInputInteger();
		
		Movie newMovie = new Movie(title, LocalDate.of(yearRelease, mouthRelease, dayRelease), new Director(firstName, lastName, LocalDateTime.of(yearDirector, mouthDirector, dayDirector, 0, 0)));
		
		movies.add(newMovie);
	}
	
	private void chooseAction() {
		
		boolean Exit = false;
		
		do {
			
			this.printMenu(VideothequeMenu.values());
			ConsoleManager.getInstance().printToConsole("Choisi une action > ", false);
			int action = ConsoleManager.getInstance().readUserInputInteger();
			
			if (handleMenuReq(VideothequeMenu.values(), action)) {
				
				if(action == 0) {
					ConsoleManager.getInstance().printToConsole("Merci d'être passer", false);
					Exit = true;
				}
				if(action == 1) {
					printList(this.data, false);
				}
				if(action == 2) {
					addMovie(this.data);
				}
				if(action == 6) {
					printListView(this.data, false, false);
				}
				if(action == 7) {
					printListView(this.data, false, true);
				}
			}
			else {
				ConsoleManager.getInstance().printLine();
				ConsoleManager.getInstance().printToConsole("je n'ai pas compris", true);
				ConsoleManager.getInstance().printLine();
			}
		} while (!Exit);

	}
}
