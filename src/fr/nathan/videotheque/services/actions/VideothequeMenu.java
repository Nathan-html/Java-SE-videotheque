package fr.nathan.videotheque.services.actions;

public enum VideothequeMenu implements ServiceMenu {
	
	LIST_MOVIES("1", "Lister les films"),
	ADD_MOVIE("2", "Ajouter un film"),
	DELETE_MOVIE("3", "Supprimer un film"),
	MOVIE_SEEN("4", "Marquer un film comme vu"),
	CHANGE_TITLE("5", "Modifier le titre d’un film"),
	LIST_MOVIE_NOT_SEEN("6", "Lister les films non-vus"),
	LIST_MOVIE_SEEN("7", "Lister les films vus"),
	SORT_MOVIES_ALPHABETICALLY("8", "Trier les films par ordre alphabétique (basé sur le titre)"),
    EXIT(ActionsConstants.EXIT_ID, ActionsConstants.EXIT_ACTION);
	
	private String value;
	private String title;
	
	private VideothequeMenu(String value, String title) {
		this.value = value;
		this.title = title;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return value + " - " + title;
	}

}
