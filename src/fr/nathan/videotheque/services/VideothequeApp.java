package fr.nathan.videotheque.services;

import java.util.List;

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
			}
			else {
				ConsoleManager.getInstance().printLine();
				ConsoleManager.getInstance().printToConsole("je n'ai pas compris", true);
				ConsoleManager.getInstance().printLine();
			}
		} while (!Exit);

	}
}
