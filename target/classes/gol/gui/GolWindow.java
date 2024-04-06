package gol.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GolWindow extends JFrame {
	public static final long serialVersionUID = 23425;
	
	public GolWindow() {
		setTitle("Gol");
		try {
			setIconImage(new ImageIcon(GolWindow.class.getResource("/images/GolLogo.png")).getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(0, 0, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
