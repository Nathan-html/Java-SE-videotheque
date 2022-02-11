package fr.nathan.videotheque.services;

import fr.nathan.videotheque.services.actions.VideothequeMenu;
import fr.nathan.videotheque.utils.ConsoleManager;

public class VideothequeApp{

	public void run() {
		printMenu(VideothequeMenu.values());
	}
	
	private void printMenu(VideothequeMenu[] menu) {
		for (VideothequeMenu item : menu) {
			ConsoleManager.getInstance().printToConsole(item.toString(), true);
		}
	}
}
