import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

public interface Interface {
	
	JFrame f_login = new JFrame();
	JFrame f_hauptmenue = new JFrame();
	JFrame f_hinzufuegen = new JFrame();
	JFrame f_entfernen = new JFrame();
	JLabel l_test = new JLabel();
	JLabel l_gerichte = new JLabel();
	JLabel l_login = new JLabel();
	JLabel l_headline = new JLabel();
	JEditorPane ep_login = new JEditorPane();
	JEditorPane ep_pw = new JEditorPane();
	JLabel l_pw = new JLabel();
	JPasswordField pf_login = new JPasswordField();
	JLabel p_logo = new JLabel(new ImageIcon("C:\\Users\\pwe\\Desktop\\Schulprojekte\\ITsys_Menue\\bitmap\\logo.png"));
	
	JLabel l_reihe = new JLabel();
	JLabel l_spalte = new JLabel();
	JLabel l_db = new JLabel();
	JLabel l_titel = new JLabel();
	JLabel l_bescheibung = new JLabel();
	JLabel l_hinweise = new JLabel();
	JLabel l_preis = new JLabel();
	JLabel l_waehrung = new JLabel();
	JLabel l_auswahl = new JLabel();
	
	JButton b_login = new JButton(); 
	JButton b_verlassen = new JButton();
	JButton b_addGericht = new JButton();
	JButton b_showGericht = new JButton();
	JButton b_db_export = new JButton();
	JButton b_db_hinzufuegen = new JButton();
	JButton b_loeschen = new JButton();
	JButton b_db_loeschen = new JButton();
	JButton b_verschieben = new JButton();
	JButton b_db_verschieben = new JButton();
	JButton b_db_bild = new JButton();
	JButton b_db_zwischenspeicher = new JButton();
	JButton b_db_delete = new JButton();
	JButton b_abbrechen = new JButton();
	JComboBox<String> cb_db = new JComboBox<String>();
	JComboBox<String> cb_food = new JComboBox<String>();
	JComboBox<String> cb_waehrung = new JComboBox<String>();
	JComboBox<String> cb_menue = new JComboBox<String>();
	JEditorPane ep_reihe = new JEditorPane();
	JEditorPane ep_spalte = new JEditorPane();
	JEditorPane ep_titel = new JEditorPane();
	JEditorPane ep_beschreibung = new JEditorPane();
	JEditorPane ep_hinweise = new JEditorPane();
	JEditorPane ep_preis = new JEditorPane();
	DB_Verbindung_herstellen db = new DB_Verbindung_herstellen();
	EventHandler _handler = new EventHandler();
	Test_DB test_db = new Test_DB();
	Gerichte gerichte = new Gerichte();
	
	public static void main(String[] args) {	
		LoadComponentsStart();
		_handler.ButtonClicked();
		_handler.Keydown();
		//DBVerbindung();
	}
	
	public static void DBVerbindung() {
		db.Verbinden();
	}
	
	public static void LoadComponentsStart() {
		
		//***Login-Fenster***\\
		CreateFrame(f_login, "Login", 1000, 800);
		CreateLabel(f_login, p_logo, "", 650, 10);
		p_logo.setSize(300, 300);
		CreateLabel(f_login, l_login, "Login:", 50, 250);
		CreateLabel(f_login, l_pw, "Passwort:", 50, 300);
		CreateLabel(f_login, l_test, "Willkommen im Interface zur Änderung der Menükarte", 50, 50);
		CreateButton(f_login, b_login, "Login", 350, 500, 100, 25);
		CreateButton(f_login, b_verlassen, "Verlassen", 550, 500, 100, 25);
		CreateEditorPane(f_login, ep_login, "", 140, 255, 100, 25);
		CreatePasswordField(f_login, pf_login, 140, 305, 100, 25);
		//*********************\\

	}
	
	public static void LoadComponentsWert() {
		String listWaehrung[] = new String[2];
		listWaehrung[0] = "€";
		listWaehrung[1] = "$";
		//***Hinzufügen_Fenster***\\
		CreateFrame(f_hinzufuegen, "Hinzufügen", 1000, 800);
		f_hinzufuegen.setVisible(false);
		CreateButton(f_hinzufuegen, b_db_bild, "Bild hochladen", 800, 300, 150, 25);
		CreateButton(f_hinzufuegen, b_db_export, "DB Export", 800, 450, 150, 25);
		CreateButton(f_hinzufuegen, b_db_hinzufuegen, "Hinzufügen", 800, 500, 150, 25);
		CreateButton(f_hinzufuegen, b_db_zwischenspeicher, "Zwischenspeichern", 800, 550, 150, 25);
		CreateButton(f_hinzufuegen, b_db_delete, "Entfernen", 800, 600, 150, 25);
		CreateButton(f_hinzufuegen, b_abbrechen, "Abbrechen", 800, 650, 150, 25);
		CreateLabel(f_hinzufuegen, l_preis, "Preis", 220, 600);
		CreateEditorPane(f_hinzufuegen, ep_preis, "", 220, 640, 75, 25);
		CreateLabel(f_hinzufuegen, l_waehrung, "Währung", 350, 600);
		CreateComboBox(f_hinzufuegen, cb_waehrung, listWaehrung, 350, 640, 150, 25);
		//CreateLabel(f_hinzufuegen, l_reihe, "Reihe:", 10, 50);
		//CreateLabel(f_hinzufuegen, l_spalte, "Spalte:", 10, 100);
		CreateLabel(f_hinzufuegen, l_db, "Kategorie:", 550, 600);
		//CreateEditorPane(f_hinzufuegen, ep_reihe, "0", 100, 50, 25, 25);
		//CreateEditorPane(f_hinzufuegen, ep_spalte, "0", 100, 100, 25, 25);
		CreateLabel(f_hinzufuegen, l_titel, "Titel:", 220, 25);
		CreateEditorPane(f_hinzufuegen, ep_titel, "", 220, 75, 550, 25);
		CreateLabel(f_hinzufuegen, l_bescheibung, "Beschreibung: ", 220, 125);
		CreateEditorPane(f_hinzufuegen, ep_beschreibung, "", 220, 175, 550, 125);
		CreateLabel(f_hinzufuegen, l_hinweise, "Allergene Hinwise:", 220, 325);
		CreateEditorPane(f_hinzufuegen, ep_hinweise, "", 220, 375, 550, 100);
		CreateComboBox(f_hinzufuegen, cb_db, test_db.dbs, 550, 640, 150, 25);
		CreateComboBox(f_hinzufuegen, cb_menue, gerichte.getListMenue(), 0, 0, 200, 25);
		//CreateScrollPane(f_hinzufuegen, sp_side_left, 0, 25, 200, 775);
		//CreateComboBox(f_hinzufuegen, cb_food, getFood_list(), 10, 150, 150, 25);
		//*******************\\
	}
	
	public static void LoadComponentsHaupt() {
		//***Hauptmenue***\\
		CreateFrame(f_hauptmenue, "Startmenü", 1000, 800);
		f_hauptmenue.setDefaultCloseOperation(f_hauptmenue.EXIT_ON_CLOSE);
		f_hauptmenue.setVisible(false);
		CreateButton(f_hauptmenue, b_addGericht, "Gericht hinzufügen", 320, 400, 150, 25);
		//CreateButton(f_hauptmenue, b_showGericht, "Gerichte zeigen", 600, 200, 150, 25);
		CreateButton(f_hauptmenue, b_loeschen, "Daten löschen", 620, 400, 150, 25);
		CreateButton(f_hauptmenue, b_verschieben, "Verschieben", 470, 500, 150, 25);
		CreateLabel(f_hauptmenue, l_headline, "Peter Meyer Gastro", 450, 50);
		l_headline.setFont(new Font("Arial", 2, 25));
		CreateComboBox(f_hauptmenue, cb_menue, gerichte.getListMenue(), 0, 0, 200, 25);
		GerichtList gerichtlist = new GerichtList();
		f_hauptmenue.add(gerichtlist.getGerichtList());
		
		
		
		//*****************\\
	}
	
	public static void LoadComponentsEntfernen() {
		CreateFrame(f_entfernen, "Daten entfernen / verschieben", 1000, 800);
		CreateComboBox(f_entfernen, cb_menue, gerichte.getListMenue(), 0, 0, 200, 25);
		//CreateScrollPane(f_entfernen, sp_side_left, 0, 25, 200, 775);
		CreateLabel(f_entfernen, l_auswahl, "Ausgewählte Menüs:", 300, 200);
		CreateButton(f_entfernen, b_db_loeschen, "Löschen", 600, 400, 150, 25);
		CreateButton(f_entfernen, b_db_verschieben, "Verschieben", 600, 300, 150, 25);
		f_entfernen.setVisible(false);
	}
	
	public static void CreateFrame(JFrame frame, String text, int width, int height) {
		frame.setTitle(text);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setLocation(50,50);
		frame.setVisible(true);
	}
	
	public static void CreateLabel(JFrame frame, JLabel label, String text, int x, int y) {
		label.setText(text);
		label.setSize(500, 30);
		label.setLocation(x, y);
		label.setVisible(true);
		frame.add(label);
	}

	public static void CreateButton(JFrame frame, JButton button, String text, int x, int y, int width, int hight) {
		button.setText(text);
		button.setBounds(x, y, width, hight);
		button.setVisible(true);
		frame.add(button);
	}
	public static void CreateComboBox(JFrame frame, JComboBox<String> combobox, String list[], int x, int y, int width, int hight) {
		combobox = new JComboBox<String>(list);
		combobox.setBounds(x, y, width, hight);
		combobox.setEditable(true);
		frame.add(combobox);
	}
	
	public static void CreateEditorPane(JFrame frame, JEditorPane editorpane, String text, int x, int y, int width, int hight) {
		editorpane.setText(text);
		editorpane.setBounds(x, y, width, hight);
		editorpane.setBackground(Color.lightGray);
		editorpane.setEditable(true);
		editorpane.setVisible(true);
		frame.add(editorpane);
	}
	
	public static void CreatePasswordField(JFrame frame, JPasswordField passwordfield, int x, int y, int width, int hight) {
		passwordfield.setBounds(x, y, width, hight);
		passwordfield.setVisible(true);
		frame.add(passwordfield);
	}
	
	public static void CreatePanel(JFrame frame, JPanel panel, int x, int y, int width, int height) {
		/*JScrollPane scrollpane= new JScrollPane();
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setPreferredSize(new Dimension(width, height));
		scrollpane.setSize(width, height);
		scrollpane.setVisible(true);
		panel.add(scrollpane);
		*/
		panel.setBounds(x, y, width, height);
		panel.setLayout(new GridBagLayout());
		panel.setBorder(LineBorder.createBlackLineBorder());
		panel.setVisible(true);
		panel.updateUI();
		frame.add(panel);
	}
	
	public static void CreateDialog(JFrame frame, JDialog dialog, int x, int y, int width, int height) {
		dialog.setSize(width, height);
		dialog.setLocation(x, y);
		dialog.setVisible(true);
	}
	
	
	public static void CreateScrollPane(JFrame panel, JScrollPane scrollpane, int x, int y, int width, int height) {
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(x, y, width, height);
		panel.add(scrollpane);
		scrollpane.setVisible(true);
	}
	
	public static String[] getFood_list() {
		String food_list[] = new String[gerichte.food.size()];
		for ( int i = 1; i < gerichte.food.size(); i++) {
			food_list[i-1] = gerichte.food.get(i).toString();
		}
		return food_list;
	}
	
}
