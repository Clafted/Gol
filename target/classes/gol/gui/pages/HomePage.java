package gol.gui.pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

import gol.backend.Gol;

public class HomePage extends Page implements MouseListener {

	private class GolPanel extends JPanel {

		public static final long serialVersionUID = 2394789;
		public Gol gol;
		private Date startDate, endDate;
		private Font golFont = new Font("SansSerif", Font.PLAIN, 25);
		private Color textColor = new Color(230, 250, 230);

		public GolPanel(Gol gol) {
			this.gol = gol;
			setOpaque(false);
		}

		@SuppressWarnings("deprecation")
		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(golFont);
			g.setColor(golColor);
			g.fillRoundRect(0, 0, getWidth(), 100, (int) (getWidth() * 0.04f), (int) (getWidth() * 0.04f));
			g.setColor(textColor);
			startDate = gol.getStartDate();
			endDate = gol.getEndDate();
			g.drawString(gol.getName() + " " 
					+ (startDate.getDate() + 1) + "/" + (startDate.getMonth() + 1) + "/" + startDate.getYear() + 
					((endDate != null) ? " - "  + (endDate.getDate() + 1)  + "/" + (endDate.getMonth() + 1) + "/" + endDate.getYear() : ""), 
					20, 40);
			g.drawString(gol.getCount() + " of " + gol.getTargetCount(), 20, 70);
		}
	}

	public static final long serialVersionUID = 32421;

	private ArrayList<Gol> gols;
	private GolPanel[] golPanels;
	private Color golColor = new Color(138, 230, 138);

	public void loadPage() {
		gols = dataManager.getData();
		golPanels = new GolPanel[gols.size()];
		for (int i = 0; i < golPanels.length; i++) {
			golPanels[i] = new GolPanel(gols.get(i));
			golPanels[i].addMouseListener(this);
			add(golPanels[i]);
		}
	}


	public void paint(Graphics g) {
		for (int i = 0; i < golPanels.length; i++) {
			golPanels[i].setBounds((int) (getWidth() * 0.1), (120 * i) + 80, (int) (getWidth() * 0.8), 100);
		}
		super.paint(g);
		g.setColor(golColor);
		g.setFont(mainFont);
		g.drawString("Gols in progress:", (int) (getWidth() * 0.1), 65);
	}

	public void mouseClicked(MouseEvent e) {
		nextPage = new GolPage(((GolPanel) e.getSource()).gol);
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}