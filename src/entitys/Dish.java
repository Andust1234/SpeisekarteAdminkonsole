package entitys;

import javafx.scene.image.Image;

import java.util.List;

public class Dish {

    private String name;
    private String description;
    private float price;
    private Currency currency;
    private String alergyNotes;
    private List<Category> categories;
    private Menu menu;

    private Image image;

    public Dish(String name, String description, float price, Currency currency, String alergyNotes, List<Category> categories, Menu menu) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.alergyNotes = alergyNotes;
        this.categories = categories;
        this.menu = menu;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getAlergyNotes() {
        return alergyNotes;
    }

    public void setAlergyNotes(String alergyNotes) {
        this.alergyNotes = alergyNotes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
