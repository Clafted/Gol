package gol.gui;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class LoadingBar extends JPanel {
	
	public static final long serialVersionUID = 2304902;
	
	public float target;
	public float progress;
	public Color bgColor;
	public Color fgColor;
	
	public LoadingBar(float target, Color bgColor, Color fgColor) {
		progress = 0;
		this.target = target;
		this.bgColor = bgColor;
		this.fgColor = fgColor;
		setLayout(null);
		setOpaque(false);
	}
	
	public LoadingBar(float target, float progress, Color bgColor, Color fgColor) {
		this(target, bgColor, fgColor);
		this.progress = progress;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(bgColor);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		g.setColor(fgColor);
		if (progress > target) {
			g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		} else {
			g.fillRoundRect(0, 0, (int)(getWidth() * progress / target), getHeight(), 10, 10);
		}
	}
}
