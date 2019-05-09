import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;


public class GerichtList implements Interface {
	private int gerichtY;
	JScrollPane sp_side_left = new JScrollPane();
	
	public GerichtList() {
		Interface.CreateScrollPane(f_hauptmenue, sp_side_left, 0, 25, 200, 753);	
		CreateGerichtList();
	}
	
	public void CreateGerichtList() {
		gerichtY = 0;
		int l_scrollY = 100;
		String scroll = "<html>";
		JLabel l_scroll = new JLabel();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 183, l_scrollY);
		panel.setBackground(Color.blue);
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
		
		l_scroll.setVisible(true);
		
		
		for (int i = 0; i < 10; i++) {
			
			String text = "Gold"; // Text aus DB
			String betrag = "100€"; // Betrag aus DB
			JLabel p_picture = new JLabel(new ImageIcon("C:\\Users\\pwe\\Desktop\\Schulprojekte\\ITsys_Menue\\bitmap\\ahri_klein.jpg"));
			p_picture.setSize(300, 300);
			
			
			JPanel gericht = new JPanel();
			gericht.setLayout(new BorderLayout());
			JLabel titel = new JLabel();
			JLabel preis = new JLabel();
			JButton button = new JButton();
			
			
			button.setBounds(0, 0, 0, 0);
			gericht.setBounds(0, gerichtY, 183, 100);
			gericht.setBackground(Color.white);
			gericht.setVisible(true);
			titel.setText(text);
			titel.setVisible(true);
			preis.setText(betrag);
			preis.setVisible(true);
			gericht.add(p_picture, BorderLayout.CENTER);
			gericht.add(titel, BorderLayout.NORTH);
			gericht.add(preis, BorderLayout.SOUTH);
			gericht.setBorder(BorderFactory.createLineBorder(Color.black));
			
			gerichtY += 100;
			l_scrollY += 100; 
			//scroll += "a<br/>a<br/>a<br/>a<br/>a<br/>a<br/>a<br/>a<br/>";
			panel.setBounds(0, 0, 183, l_scrollY);
			
			
			panel.add(gericht, BorderLayout.CENTER);
			
		}
		
		scroll += "</html>";
		l_scroll.setBounds(10, 0, 10, l_scrollY);
		l_scroll.setText(scroll);
		sp_side_left.add(l_scroll);
		sp_side_left.setComponentZOrder(l_scroll, 0);
		sp_side_left.add(panel);
		sp_side_left.setComponentZOrder(panel, 0);
		sp_side_left.setViewportView(panel);
		//sp_side_left.setViewportView(l_scroll);
	}
	
	public JScrollPane getGerichtList() {
		return sp_side_left;
	}
}
