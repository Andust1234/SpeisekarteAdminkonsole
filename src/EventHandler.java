import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class EventHandler implements Interface {
	
	public void ItemSwitch() {
		
	}
	
	public void ButtonClicked() {
		String user = "dba";
		b_login.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
				if (ep_login.getText().equals(user)) {
					char[] input = pf_login.getPassword();
				    if (isPasswordCorrect(input)) {
				    	System.out.println("Success! You typed the right password.");
				    	
				    	l_test.setVisible(false);
						l_reihe.setVisible(true);
						l_spalte.setVisible(true);
						l_login.setVisible(false);
						l_pw.setVisible(false);
						l_db.setVisible(true);
						b_login.setVisible(false);
						b_addGericht.setVisible(true);
						b_showGericht.setVisible(true);
						b_db_export.setVisible(true);
						b_db_hinzufuegen.setVisible(true);
						b_db_loeschen.setVisible(true);
						cb_db.setVisible(true);
						cb_food.setVisible(true);
						ep_reihe.setVisible(true);
						ep_spalte.setVisible(true);
						ep_login.setVisible(false);
						pf_login.setVisible(false);
						
				    } 
				    
				    else {
				        System.out.println("Invalid password. Try again.");
				    }
				
				    Arrays.fill(input, '0');
				    pf_login.selectAll();	
				}
				else {
					System.out.println("Invalid User. Try again");
				}
	         }          
	     });
		
		b_verlassen.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 System.exit(0);		
	         }          
	     });
		
		b_addGericht.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 cb_food.setSelectedItem("Bacon");
	        	 System.out.println(cb_food.getSelectedItem());
	        	 if (cb_food.getSelectedItem() != null) {
		        	 String new_gericht = cb_food.getSelectedItem().toString();		
		        	 gerichte.addGericht(gerichte.food, new_gericht);
	        	 }
	         }          
	     });
		
		b_showGericht.addActionListener(new ActionListener() {
			 String show_list = "";
	         public void actionPerformed(ActionEvent e) {
	        	 if (l_gerichte.isVisible()) {
	        		 l_gerichte.setVisible(false);
	        		 show_list = "";
	        	 }
	        	 else {
		        	 ArrayList list = gerichte.getList();
		        	 System.out.println(list.size());
		        	 for ( int i = 0; i < list.size(); i++) {
		        		 if (i == list.size()-1) {
		        			 show_list += list.get(i).toString();
		        			 show_list += "\n";
		        		 }
		        		 else {
		        			 show_list += list.get(i).toString() + ", ";
			        		 show_list += "\n";
		        		 }
		     		 }
		        	 System.out.print(show_list);
		     		 Interface.CreateLabel(l_gerichte, show_list, 700, 500);
		     		 l_gerichte.setVisible(true);
	        	 }
	         } 
	     });
		
		b_db_export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test_db.DB_export(test_db.food);
			}
		});
		b_db_hinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test_db.Daten_hinzufügen(test_db.food, "Wasser");
				
			}
		});
		b_db_loeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test_db.Daten_löschen(test_db.food, Integer.valueOf(ep_reihe.getText()).intValue(), Integer.valueOf(ep_spalte.getText()).intValue());
			}
		});
	}
	
	private boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 's', 'q', 'l'};

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
}
 