import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class EventHandler implements Interface {
	
	public void ItemSwitch() {
		
	}
	
	public void Keydown() {
		IsKeyPressed iskeypressed = new IsKeyPressed();
		
		ep_login.addKeyListener(new KeyListener() {
		
			@Override
			public void keyPressed(KeyEvent arg0) {
				iskeypressed.getKey();
				if (iskeypressed.isTABPressed()) {
					pf_login.grabFocus();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
	}
		
	
	public void ButtonClicked() {
		String user = "dba";
		b_login.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
				if (ep_login.getText().equals(user)) {
					char[] input = pf_login.getPassword();
				    if (isPasswordCorrect(input)) {
				    	System.out.println("Success! You typed the right password.");
				    	
				    	Interface.LoadComponentsHaupt();
				    	f_hauptmenue.setVisible(true);
				    	f_login.setVisible(false);
				    	//f_login.remove(f_login);
						
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
	        	 Interface.LoadComponentsWert();
	        	 f_hinzufuegen.setVisible(true);
	        	 /*System.out.println(cb_food.getSelectedItem());
	        	 if (cb_food.getSelectedItem() != null) {
		        	 String new_gericht = cb_food.getSelectedItem().toString();		
		        	 gerichte.addGericht(gerichte.food, new_gericht);
	        	 }
	        	 */
	         }          
	     });
		
		b_showGericht.addActionListener(new ActionListener() {
			 String show_list = "", item;
	         public void actionPerformed(ActionEvent e) {
	        	 if (l_gerichte.isVisible()) {
	        		 l_gerichte.setVisible(false);
	        		 show_list = "";
	        	 }
	        	 else {
	        		 item = (String) Interface.cb_db.getSelectedItem();
		        	 ArrayList<String> list = gerichte.getList(item);
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
		     		 Interface.CreateLabel(f_login, l_gerichte, show_list, 700, 500);
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
				String titel, item;
				String selected_db[][] = new String[1][test_db.dbs.length];
				titel = Interface.ep_titel.getName();
				item = (String) Interface.cb_db.getSelectedItem();
				selected_db = test_db.List2Array(gerichte.getList(item));
				test_db.Daten_hinzufügen(selected_db, titel);
				
			}
		});
		
		b_loeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.LoadComponentsEntfernen();
				f_entfernen.setVisible(true);
			}
				/*String data[][] = new String[0][0];
				System.out.println(cb_db.getSelectedItem());
				if (cb_db.getSelectedItem() != null) {
					System.out.println(cb_db.getSelectedItem());
					String db = cb_db.getSelectedItem().toString();
					switch (db) {
					case "food":
						data = test_db.food;
						
					case "drink":
						data = test_db.drink;
						
					case "order":
						data = test_db.order;
						
					}
						
					test_db.Daten_löschen(data, Integer.valueOf(ep_reihe.getText()).intValue(), Integer.valueOf(ep_spalte.getText()).intValue());
				}
				else {
					System.out.println("GEHT NICH");
				}
			}
			*/
		});
		
		b_verschieben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.LoadComponentsEntfernen();
				f_entfernen.setVisible(true);
			}
		});
		
		b_abbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_hinzufuegen.setVisible(false);
				//f_hinzufuegen.remove(f_hinzufuegen);
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
 