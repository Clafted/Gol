package gol.gui.pages;

import gol.backend.DataManager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

public class Page extends JPanel {
	
	public static final long serialVersionUID = 324261;
	public static DataManager dataManager;
	public Page nextPage = null;
	
	protected static Color backgroundColor = new Color(200, 230, 200);
	protected Color mainColor = new Color(148, 240, 148);
	protected static Font mainFont = new Font("SansSerif", Font.PLAIN, 40);
	protected static Font titleFont = new Font("SansSerif", Font.PLAIN, 80);
	
	public Page() {
		setBackground(backgroundColor);
		setLayout(null);
	}
	
	public void loadPage() {};
}
