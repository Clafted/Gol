package gol.gui;

import javax.swing.JFrame;
import gol.gui.pages.*;

public class GolWindow extends JFrame {
	public static final long serialVersionUID = 23425;
	
	public GolWindow() {
		setTitle("Gol");
		setBounds(0, 0, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(new HomePage());
		getContentPane().setBounds(getBounds());
		setVisible(true);
	}
}
