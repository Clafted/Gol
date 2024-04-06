package gol;

import java.time.Instant;
import java.util.Date;

import gol.backend.*;
import gol.gui.GolWindow;
import gol.gui.pages.HomePage;
import gol.gui.pages.Page;

public class Main {
	public static void main(String[] args) {
		// File reading/writing is working
		// Next Gol: add frontend functionality
		Page.dataManager = new DataManager();
		GolWindow window = new GolWindow();
		Page currentPage = new Page();
		currentPage.nextPage = new HomePage();
		while (window.isShowing()) {
			if (currentPage.nextPage != null) {
				Page newPage = currentPage.nextPage;
				newPage.setBounds(window.getBounds());
				currentPage = newPage;
				currentPage.loadPage();
				window.setContentPane(currentPage);
				window.repaint();
			}
		};
		System.exit(0);
	}
}
