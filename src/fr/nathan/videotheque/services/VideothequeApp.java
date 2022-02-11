package fr.nathan.videotheque.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import fr.nathan.videotheque.models.Director;
import fr.nathan.videotheque.models.Movie;
import fr.nathan.videotheque.services.data.MovieData;
import fr.nathan.videotheque.services.menu.VideothequeMenu;
import fr.nathan.videotheque.utils.ConsoleManager;

public class VideothequeApp{

	private List<Movie> data = new MovieData().getVidetheque();
	
	public void run() {
		ConsoleManager.getInstance().printToConsole(
				"--------------------------------\r\n" +
				"| Bienvenu dans la vidéotheque |\r\n" +
				"--------------------------------", true);
		chooseAction();
	}
	
	private void printMenu(VideothequeMenu[] menu) {
		for (VideothequeMenu item : menu) {
			ConsoleManager.getInstance().printToConsole(item.toString(), true);
		}
	}
	
	private void printList(List<Movie> movies, Boolean option) {
		list(movies, option);
		ConsoleManager.getInstance().printLine();
	}
	
	private void printListView(List<Movie> movies, Boolean option, Boolean isView) {
		listView(movies, option, isView);
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
	
	private void listView(List<Movie> movies, Boolean option, Boolean isView) {
		if (!movies.isEmpty()) {
			int id = 1;
			for (Movie movie : movies) {
				if (isView) {
					if (option && movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole(id + " - " + movie.toString(), true);
						id++;
					}
					if(!option && movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole("> " + movie.toString(), true);
						id++;
					}
				} else {
					if (option && !movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole(id + " - " + movie.toString(), true);
						id++;
					}
					if(!option && !movie.getWasViewed()) {
						ConsoleManager.getInstance().printToConsole("> " + movie.toString(), true);
						id++;
					}
				}
			}
			if(id == 1) {
				ConsoleManager.getInstance().printToConsole("Aucun film n'a été trouvée", true);
			}
		} else {
			ConsoleManager.getInstance().printToConsole("Aucun film n'a été trouvée", true);
		}
	}
	
	private void deleteMovie(List<Movie> movies) {
		this.printList(movies, true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int choose = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("Le film " + movies.get(choose-1).getTitle() +" a bien été suprimer", true);
		movies.remove(choose-1);
		ConsoleManager.getInstance().printLine();
	}
	
	private void setAsView(List<Movie> movies) {
		this.printList(movies, true);
		int choose = ConsoleManager.getInstance().readUserInputInteger();
		movies.get(choose-1).setWasViewed(true);
	}
	
	private void changeTitle(List<Movie> movies) {
		this.printList(movies, true);
		ConsoleManager.getInstance().printToConsole("choisisez un film", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int choose = ConsoleManager.getInstance().readUserInputInteger();
		ConsoleManager.getInstance().printToConsole("entrer le nouveau nom du film", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		String newTitle = ConsoleManager.getInstance().readUserInput();
		movies.get(choose-1).setTitle(newTitle);
	}
	
	private void addMovie(List<Movie> movies) {

		ConsoleManager.getInstance().printToConsole("Rentrer :", true);
		ConsoleManager.getInstance().printToConsole("le nom du film", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		String title = ConsoleManager.getInstance().readUserInput();
		
		ConsoleManager.getInstance().printToConsole("la date de sortie du film", true);
		ConsoleManager.getInstance().printToConsole("anner", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int yearRelease = ConsoleManager.getInstance().readUserInputInteger();
		ConsoleManager.getInstance().printToConsole("mois", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int mouthRelease = ConsoleManager.getInstance().readUserInputInteger();
		ConsoleManager.getInstance().printToConsole("jour", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int dayRelease = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("le prenom du realisateur", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		String firstName = ConsoleManager.getInstance().readUserInput();
		ConsoleManager.getInstance().printToConsole("et son nom", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		String lastName = ConsoleManager.getInstance().readUserInput();
		
		ConsoleManager.getInstance().printToConsole("sa date de naissance", true);
		ConsoleManager.getInstance().printToConsole("anner", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int yearDirector = ConsoleManager.getInstance().readUserInputInteger();
		ConsoleManager.getInstance().printToConsole("mois", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int mouthDirector = ConsoleManager.getInstance().readUserInputInteger();
		ConsoleManager.getInstance().printToConsole("jour", true);
		ConsoleManager.getInstance().printToConsole("> ", false);
		int dayDirector = ConsoleManager.getInstance().readUserInputInteger();
		
		/*
		 * J'ai décidé de ne pas demander heure et minute pour des raisons de clarté
		 * 
		 * Et je n'ai également pas pu demander à l'utilisateur si souhaiter créer un nouveau réalisateur
		 * ou utiliser un des réalisateurs stocker dans une liste par manque de temps
		 */
		
		Movie newMovie = new Movie(title, LocalDate.of(yearRelease, mouthRelease, dayRelease), new Director(firstName, lastName, LocalDateTime.of(yearDirector, mouthDirector, dayDirector, 0, 0)));
		
		movies.add(newMovie);
	}
	
    private void sort(List<Movie> movies) {
    	movies.sort(Comparator.comparing(Movie::getTitle));
    	list(data, false);
    }
	
	private void chooseAction() {
		
		boolean Exit = false;
		
		do {
			ConsoleManager.getInstance().printToConsole(
					"-------------------------------\r\n"+
					"| Veuillez choisir une action |\r\n"+
					"-------------------------------", true);
			this.printMenu(VideothequeMenu.values());
			ConsoleManager.getInstance().printToConsole("> ", false);
			int action = ConsoleManager.getInstance().readUserInputInteger();
			
			if (handleMenuReq(VideothequeMenu.values(), action)) {
				
				if(action == 0) {
					ConsoleManager.getInstance().printToConsole(
							"----------------------------------\r\n"+
							"| Merci d'être passer ( ´ ^ ` )/ |\r\n"+
							"----------------------------------", true);
					Exit = true;
				}
				if(action == 1) {
					ConsoleManager.getInstance().printToConsole(
							"-------------------\r\n"+
							"| Liste des films |\r\n"+
							"-------------------", true);
					list(this.data, false);
				}
				if(action == 2) {
					ConsoleManager.getInstance().printToConsole(
							"-------------------\r\n"+
							"| Ajouter un film |\r\n"+
							"-------------------", true);
					addMovie(this.data);
				}
				if(action == 3) {
					ConsoleManager.getInstance().printToConsole(
							"---------------------\r\n"+
							"| Supprimer un film |\r\n"+
							"---------------------", true);
					deleteMovie(this.data);
				}
				if(action == 4) {
					ConsoleManager.getInstance().printToConsole(
							"----------------------------\r\n"+
							"| Marquer un film comme vu |\r\n"+
							"----------------------------", true);
					setAsView(this.data);
				}
				if(action == 5) {
					ConsoleManager.getInstance().printToConsole(
							"-------------------------------\r\n"+
							"| Modifier le titre d’un film |\r\n"+
							"-------------------------------", true);
					changeTitle(this.data);
				}
				if(action == 6) {
					ConsoleManager.getInstance().printToConsole(
							"----------------------------\r\n"+
							"| Lister les films non-vus |\r\n"+
							"----------------------------", true);
					listView(this.data, false, false);
				}
				if(action == 7) {
					ConsoleManager.getInstance().printToConsole(
							"------------------------\r\n"+
							"| Lister les films vus |\r\n"+
							"------------------------", true);
					listView(this.data, false, true);
				}
				if(action == 8) {
					ConsoleManager.getInstance().printToConsole(
							"--------------------------------\r\n"+
							"| Films par ordre alphabétique |\r\n"+
							"--------------------------------", true);
					sort(this.data);
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
