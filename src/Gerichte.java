import java.util.ArrayList;

public class Gerichte implements Interface {
	
	protected ArrayList<String> food = new ArrayList<String>();
	protected ArrayList<String> drink = new ArrayList<String>();
	protected ArrayList<String> service = new ArrayList<String>();
	protected ArrayList<String> inhaltsstoffe = new ArrayList<String>();
	protected ArrayList<Integer> price = new ArrayList<Integer>();
	protected ArrayList<String> order = new ArrayList<String>();
	
	public Gerichte() {
		for (int i = 0; i < test_db.food.length; i++) {
			food.add(test_db.food[1][i]);
		}
	}
	
	public ArrayList getList() {
		return food;
	}
	
	public void addGericht(ArrayList list, String new_gericht) {
		list.add(new_gericht);
	}
	
	public void changeItem(ArrayList list, String alt_gericht, String new_gericht) {
		for ( int i = 0; i < list.size(); i++) {
			String gericht = list.get(i).toString();
			if (gericht == alt_gericht) {
				list.add(i, new_gericht);
			}
		}
	}
	
	public void setPrice(ArrayList list, int price) {
		
	}
	
}
