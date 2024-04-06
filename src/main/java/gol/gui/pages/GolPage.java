package gol.gui.pages;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import gol.gui.LoadingBar;
import gol.backend.Gol;

public class GolPage extends Page {
	
	public static final long serialVersionUID = 392482084;
	
	private Gol gol;
	private LoadingBar progress;
	
	public GolPage(Gol gol) {
		this.gol = gol;
		progress = new LoadingBar(3, 2, mainColor, new Color(10, 210, 10));
		setBackground(backgroundColor);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(titleFont);
		g.setColor(mainColor);
		g.drawString(gol.getName(), 50 , 100);
		g.setFont(mainFont);
		Date[] logDates = {};
		HashMap<Date, Float> logs = gol.getLogs();
		logDates = gol.getLogs().keySet().toArray(logDates);
		g.setColor(mainColor);
		g.fillRoundRect(50, 190, getWidth() - 100, logDates.length * (mainFont.getSize() + 5) + 40, 40, 40);
		g.setColor(progress.fgColor);
		for (int i = 0; i < logDates.length; i++) {
			g.drawString(logDates[i].getMonth() + 1 + "/" + logDates[i].getDate() + 1 + ": " + logs.get(logDates[i]) + " of " + gol.getCount(), 70, 250 + ((mainFont.getSize() + 5) * i));
		}
	}
	
	public void loadPage() {
		System.out.println("Loading Gol: " + gol.getName());
		progress.setBounds(50, 130, 400, 30);
		add(progress);
	}
}
