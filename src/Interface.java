import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.*;

public interface Interface {
	
	//Login
	JFrame f_start = new JFrame();
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
		LoadComponents();
		_handler.ButtonClicked();
		DBVerbindung();
	}
	
	public static void LoadComponents() {
		String food_list[] = new String[gerichte.food.size()];
		for ( int i = 1; i < gerichte.food.size(); i++) {
			food_list[i-1] = gerichte.food.get(i).toString();
		}
		
		//Login-Fenster
		CreateFrame(f_start, "Startmenü");
		CreateLabel(l_login, "Login:", 50, 250);
		l_login.setVisible(true);
		CreateLabel(l_pw, "Passwort:", 50, 300);
		l_pw.setVisible(true);
		CreateLabel(l_test, "Willkommen im Interface zur Änderung der Menükarte", 50, 50);
		l_test.setVisible(true);
		CreateButton(b_login, "Login", 350, 500, 100, 25);
		b_login.setVisible(true);
		CreateButton(b_verlassen, "Verlassen", 550, 500, 100, 25);
		b_verlassen.setVisible(true);
		CreateEditorPane(ep_login, "", 140, 255, 100, 25);
		ep_login.setVisible(true);
		CreatePasswordField(pf_login, 140, 305, 100, 25);
		pf_login.setVisible(true);
		
		
		CreateLabel(l_reihe, "Reihe:", 300, 300);
		CreateLabel(l_spalte, "Spalte:", 300, 350);
		CreateLabel(l_db, "Datenbank:", 270, 247);
		CreateButton(b_addGericht, "Gericht hinzufügen", 400, 200, 150, 25);
		CreateButton(b_showGericht, "Gerichte zeigen", 600, 200, 150, 25);
		CreateButton(b_db_export, "DB Export", 200, 100, 150, 25);
		CreateButton(b_db_hinzufuegen, "Hinzufügen", 400, 100, 150, 25);
		CreateButton(b_db_loeschen, "Daten löschen", 600, 100, 150, 25);
		CreateComboBox(cb_db, test_db.dbs, 350, 250, 150, 25);
		cb_db.setVisible(false);
		System.out.println(cb_db.isVisible());
		CreateComboBox(cb_food, food_list, 200, 200, 150, 25);
		cb_food.setVisible(false);
		CreateEditorPane(ep_reihe, "0", 350, 305, 25, 25);
		CreateEditorPane(ep_spalte, "0", 350, 355, 25, 25);
	}
	public static void CreateFrame(JFrame frame, String text) {
		frame.setTitle(text);
		frame.setLayout(null);
		frame.setSize(1000, 620);
		frame.setResizable(true);
		frame.setLocation(50,50);
		frame.setVisible(true);
	}
	
	public static void CreateLabel(JLabel label, String text, int x, int y) {
		label.setText(text);
		label.setSize(500, 30);
		label.setLocation(x, y);
		label.setVisible(false);
		f_start.add(label);
	}

	public static void CreateButton(JButton button, String text, int x, int y, int width, int hight) {
		button.setText(text);
		button.setBounds(x, y, width, hight);
		button.setVisible(false);
		f_start.add(button);
	}
	public static void CreateComboBox(JComboBox combobox, String list[], int x, int y, int width, int hight) {
		combobox = new JComboBox(list);
		combobox.setBounds(x, y, width, hight);
		combobox.setEditable(true);
		f_start.add(combobox);
	}
	
	public static void CreateEditorPane(JEditorPane editorpane, String text, int x, int y, int width, int hight) {
		editorpane.setText(text);
		editorpane.setBounds(x, y, width, hight);
		editorpane.setEditable(true);
		editorpane.setVisible(false);
		f_start.add(editorpane);
	}
	
	public static void CreatePasswordField(JPasswordField passwordfield, int x, int y, int width, int hight) {
		passwordfield.setBounds(x, y, width, hight);
		passwordfield.setVisible(false);
		f_start.add(passwordfield);
	}
	
	public static void DBVerbindung() {
		db.Verbinden();
	}
}
