import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 

public class Test_DB {
	String dbs[] = new String[3];
	String food[][] = new String[5][5];
	String drink[][] = new String[5][5];
	String order[][] = new String[5][5];
	public Test_DB() {
		food[0][0] = "nr";
		food[0][1] = "1";
		food[0][2] = "2";
		food[0][3] = "3";
		food[0][4] = "4";
		food[1][0] = "name";
		food[1][1] = "Ei";
		food[1][2] = "Bacon";
		food[1][3] = "Speck";
		food[1][4] = "Pizza";
		
		dbs[0] = "food";
		dbs[1] = "drink";
		dbs[2] = "order";
		
	}
	
	public void Daten_hinzufügen(String[][] tabelle, String eintrag) {
		for (int i = 0; i < tabelle.length; i++) {
			int a = 1;
			for ( int z = 0; z < tabelle.length; z++) {
				if (tabelle[z][i] == "" || tabelle[z][i] == null && tabelle[z][i] != eintrag) {
					tabelle[z][i] = eintrag;
					a = 0;
					break;
				}
				else {
					System.out.println("Es ist schon ein Eintrag vorhanden!");
				}
			}
			if ( a != 1 ) {
				break;
			}
		}
	}
	
	public void Daten_ändern(String[][] tabelle, int spalte, int reihe, String eintrag) {
		System.out.println(tabelle[spalte][reihe] + " wird zu " + eintrag + " geändert!" );
		tabelle[spalte][reihe] = eintrag;
	}
	
	public void Daten_löschen(String[][] tabelle, int spalte, int reihe) {
		System.out.println(tabelle[spalte][reihe] + " wird gelöscht!" );
		tabelle[spalte][reihe] = "";
	}
	
	public void DB_export(String[][] tabelle) {
		PrintWriter pWriter = null; 
        try { 
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("DB_test.txt"))); 
            for (int i = 0; i < tabelle.length; i++) {
            	pWriter.println(" ");
            	for (int z = 0; z < tabelle.length; z++) {
            		pWriter.print(tabelle[z][i] + "	"); 
            	}
            }
            
            
        } 
        catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        finally { 
            if (pWriter != null){ 
                pWriter.flush(); 
                pWriter.close(); 
            } 
        } 
	}
	
	public void DB_import() {
		
	}
	
}
