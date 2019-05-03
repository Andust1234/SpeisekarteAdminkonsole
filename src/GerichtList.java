import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class GerichtList implements Interface {
	private int gerichtY;
	
	public GerichtList() {
	}
	
	public JPanel CreateGerichtList() {
		JPanel gericht = new JPanel();
		JLabel titel = new JLabel();
		JLabel preis = new JLabel();
		JButton button = new JButton();
		//JLabel p_logo = new JLabel(new ImageIcon("C:\\Users\\pwe\\Desktop\\Schulprojekte\\ITsys_Menue\\bitmap\\logo.png"));

		gerichtY = 0;
		String text = "Gold"; // Text aus DB
		String betrag = "100€"; // Betrag aus DB
		
		for (int i = 0; i > 5 /*Count aus DB*/; i++) {
			
			button.setBounds(0, 0, 0, 0);
			gericht.setBounds(0, gerichtY, 183, 100);
			gericht.setBackground(Color.white);
			gericht.setVisible(true);
			titel.setText(text);
			titel.setBounds(50, 5, 45, 25);
			titel.setVisible(true);
			preis.setText(betrag);
			preis.setBounds(100, 35, 45, 25);
			preis.setVisible(true);
			gericht.add(titel);
			gericht.add(preis);
			
			gerichtY += 100;
		}
		
		return gericht;
	}
}
