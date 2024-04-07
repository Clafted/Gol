package gol.gui.functions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JTextField;

import gol.backend.Gol;

public class Log extends JButton {
	
	public static final long serialVersionUID = 12325;
	
	public boolean opened = false;
	public JTextField field;
	private Font font = new Font("SansSerif", Font.PLAIN, 20);
	private Color color;
	
	public Log(int x, int y, Color color, Gol gol) {
		this.color = color;
		setBounds(x, y, 60, 30);
		setBackground(null);
		setLayout(null);
		setBorder(null);
		setFocusable(false);
		field = new JTextField();
		field.setBounds(55, 5, 40, 20);
		field.setBackground(Color.WHITE);
		field.setVisible(false);
		add(field);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Log", 10, 22);
		paintComponents(g);
	}

}
