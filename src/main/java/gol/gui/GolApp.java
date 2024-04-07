package gol.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gol.gui.pages.HomePage;
import gol.gui.pages.Page;

public class GolApp {
	
	private JFrame window;
	private Page currentPage;
	private NavBar navBar;
	
	public GolApp() {
		currentPage = null;
	}
	
	public void startApp() {
		window = new JFrame("Gol");
		window.setBounds(0, 0, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(null);
		navBar = new NavBar(window.getWidth(), window.getHeight() - 40);
		currentPage = new Page();
		currentPage.nextPage = new HomePage();
		while (window.isShowing()) {
			window.repaint();
			if (currentPage.nextPage != null) {
				Page newPage = currentPage.nextPage;
				newPage.setBounds(window.getBounds());
				newPage.loadPage();
				newPage.add(navBar);
				currentPage = newPage;
				window.setContentPane(newPage);
				window.revalidate();
			}
		};
	}
	
	private class NavBar extends JPanel {
		public static final long serialVersionUID = 132151;
		
		private JButton home;
		
		public NavBar(int width, int height) {
			setLayout(null);
			setBackground(new Color(140, 200, 140));
			setBounds(0, height - 60, width, 60);
			home = new JButton("Home");
			home.setBounds(getWidth()/2 - 20, getHeight()/2 - 20, 40, 40);
			home.setBackground(null);
			home.setBorder(null);
			home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentPage.nextPage = new HomePage();
				}
			});
			add(home);
		}
	}
}
