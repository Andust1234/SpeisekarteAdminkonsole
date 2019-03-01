import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.*;

public interface Interface {
	
	//Login
	JFrame f_start = new JFrame();
	JFrame f_werte = new JFrame();
	JLabel l_test = new JLabel();
	JLabel l_gerichte = new JLabel();
	JLabel l_login = new JLabel();
	JEditorPane ep_login = new JEditorPane();
	JEditorPane ep_pw = new JEditorPane();
	JLabel l_pw = new JLabel();
	JPasswordField pf_login = new JPasswordField();
	
	JLabel l_reihe = new JLabel();
	JLabel l_spalte = new JLabel();
	JLabel l_db = new JLabel();
	JButton b_login = new JButton(); 
	JButton b_verlassen = new JButton();
	JButton b_addGericht = new JButton();
	JButton b_showGericht = new JButton();
	JButton b_db_export = new JButton();
	JButton b_db_hinzufuegen = new JButton();
	JButton b_db_loeschen = new JButton();
	JComboBox<String> cb_db = new JComboBox<String>();
	JComboBox<String> cb_food = new JComboBox<String>();
	JEditorPane ep_reihe = new JEditorPane();
	JEditorPane ep_spalte = new JEditorPane();
	DB_Verbindung_herstellen db = new DB_Verbindung_herstellen();
	EventHandler _handler = new EventHandler();
	Test_DB test_db = new Test_DB();
	Gerichte gerichte = new Gerichte();
	
	public static void main(String[] args) {		
		LoadComponentsStart();
		LoadComponentsWert();
		_handler.ButtonClicked();
		DBVerbindung();
	}
	
	public static void LoadComponentsStart() {
		
		//***Login-Fenster***\\
		CreateFrame(f_start, "Startmenü", 1000, 800);
		CreateLabel(f_start, l_login, "Login:", 50, 250);
		l_login.setVisible(true);
		CreateLabel(f_start, l_pw, "Passwort:", 50, 300);
		l_pw.setVisible(true);
		CreateLabel(f_start, l_test, "Willkommen im Interface zur Änderung der Menükarte", 50, 50);
		l_test.setVisible(true);
		CreateButton(f_start, b_login, "Login", 350, 500, 100, 25);
		b_login.setVisible(true);
		CreateButton(f_start, b_verlassen, "Verlassen", 550, 500, 100, 25);
		b_verlassen.setVisible(true);
		CreateEditorPane(f_start, ep_login, "", 140, 255, 100, 25);
		ep_login.setVisible(true);
		CreatePasswordField(f_start, pf_login, 140, 305, 100, 25);
		pf_login.setVisible(true);
		//*********************\\
		
		CreateButton(f_start, b_addGericht, "Gericht hinzufügen", 400, 200, 150, 25);
		CreateButton(f_start, b_showGericht, "Gerichte zeigen", 600, 200, 150, 25);
		CreateButton(f_start, b_db_export, "DB Export", 200, 100, 150, 25);
		CreateButton(f_start, b_db_hinzufuegen, "Hinzufügen", 400, 100, 150, 25);
		CreateButton(f_start, b_db_loeschen, "Daten löschen", 600, 100, 150, 25);


	}
	public static void CreateFrame(JFrame frame, String text, int width, int height) {
		frame.setTitle(text);
		frame.setLayout(null);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setLocation(50,50);
		frame.setVisible(true);
	}
	
	public static void CreateLabel(JFrame frame, JLabel label, String text, int x, int y) {
		label.setText(text);
		label.setSize(500, 30);
		label.setLocation(x, y);
		label.setVisible(false);
		frame.add(label);
	}

	public static void CreateButton(JFrame frame, JButton button, String text, int x, int y, int width, int hight) {
		button.setText(text);
		button.setBounds(x, y, width, hight);
		button.setVisible(false);
		frame.add(button);
	}
	public static void CreateComboBox(JFrame frame, JComboBox combobox, String list[], int x, int y, int width, int hight) {
		combobox = new JComboBox(list);
		combobox.setBounds(x, y, width, hight);
		combobox.setEditable(true);
		frame.add(combobox);
	}
	
	public static void CreateEditorPane(JFrame frame, JEditorPane editorpane, String text, int x, int y, int width, int hight) {
		editorpane.setText(text);
		editorpane.setBounds(x, y, width, hight);
		editorpane.setEditable(true);
		editorpane.setVisible(false);
		frame.add(editorpane);
	}
	
	public static void CreatePasswordField(JFrame frame, JPasswordField passwordfield, int x, int y, int width, int hight) {
		passwordfield.setBounds(x, y, width, hight);
		passwordfield.setVisible(false);
		frame.add(passwordfield);
	}
	
	public static void DBVerbindung() {
		db.Verbinden();
	}
	
	public static void LoadComponentsWert() {
		//***Werte_Fenster***\\
		CreateFrame(f_werte, "Werte", 500, 250);
		f_werte.setVisible(false);
		CreateLabel(f_werte, l_reihe, "Reihe:", 10, 50);
		l_reihe.setVisible(true);
		CreateLabel(f_werte, l_spalte, "Spalte:", 10, 100);
		l_spalte.setVisible(true);
		CreateLabel(f_werte, l_db, "Datenbank:", 10, 10);
		l_db.setVisible(true);
		CreateEditorPane(f_werte, ep_reihe, "0", 100, 50, 25, 25);
		ep_reihe.setVisible(true);
		CreateEditorPane(f_werte, ep_spalte, "0", 100, 100, 25, 25);
		ep_spalte.setVisible(true);
		CreateComboBox(f_werte, cb_db, test_db.dbs, 100, 10, 150, 25);
		cb_db.setVisible(true);
		CreateComboBox(f_werte, cb_food, getFood_list(), 10, 150, 150, 25);
		cb_food.setVisible(true);
		//*******************\\
	}
	
	public static String[] getFood_list() {
		String food_list[] = new String[gerichte.food.size()];
		for ( int i = 1; i < gerichte.food.size(); i++) {
			food_list[i-1] = gerichte.food.get(i).toString();
		}
		return food_list;
	}
}
