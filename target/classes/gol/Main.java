package gol;

import gol.backend.*;
import gol.gui.GolApp;
import gol.gui.pages.Page;

public class Main {
	public static void main(String[] args) {
		// File reading/writing is working
		// Next Gol: add frontend functionality
		Page.dataManager = new DataManager();
		GolApp app = new GolApp();
		app.startApp();
		Page.dataManager.saveData();
		System.exit(0);
	}
}
