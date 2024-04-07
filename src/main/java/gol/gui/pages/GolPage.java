package gol.gui.pages;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import gol.gui.LoadingBar;
import gol.gui.functions.Log;
import gol.backend.Gol;

public class GolPage extends Page implements ActionListener {
	
	public static final long serialVersionUID = 392482084;
	
	private Gol gol;
	private LoadingBar progress;
	private Log log;
	
	public GolPage(Gol gol) {
		this.gol = gol;
		progress = new LoadingBar(3, 2, mainColor, new Color(10, 210, 10));
		progress.setBounds(50, 130, 400, 30);
		log = new Log(470, 130, progress.fgColor, gol);
		log.addActionListener(this);
		add(progress);
		add(log);
	}
	
	@SuppressWarnings("deprecation")
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
			g.drawString(logDates[i].getMonth() + 1 + "/" + logDates[i].getDate() + 1 + "/" + logDates[i].getYear() + ": " + logs.get(logDates[i]) + " of " + gol.getCount(), 70, 250 + ((mainFont.getSize() + 5) * i));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(log)) {
			if (!log.opened) {
				if (!log.field.getText().equals("")) {
					try {
						gol.increment(Date.from(Instant.now()), Float.parseFloat(log.field.getText()));
						progress.progress = gol.getCount();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				log.field.setText("");
				log.setSize(60, 30);
			} else {
				log.setSize(110, 30);
			}
			log.field.setVisible(log.opened);
			log.opened = !log.opened;
			repaint();
		}
	}

}
