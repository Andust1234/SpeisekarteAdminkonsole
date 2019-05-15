package mock;

import entitys.Category;
import entitys.Currency;
import entitys.Dish;
import entitys.Menu;
import javafx.scene.image.Image;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class MockGenerator {

    private MockGenerator instance;

    public MockGenerator getInstance() {
        if (instance == null) {
            instance = new MockGenerator();
        }
        return instance;
    }

    public static List<Dish> generateDishes(int size) {
        List<Dish> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(generateDish());
        }
        return result;
    }

    private static Dish generateDish() {
       Dish dish = new Dish(getRandomString(10), getRandomString(40), getRandomFloat(), getRandomCurrency(), getRandomString(20), getRandomCategory(), getRandomMenu());
       dish.setImage(getRandomImage());
       return dish;
    }

    private static Menu getRandomMenu() {
        switch (ThreadLocalRandom.current().nextInt(1, 3 + 1)) {
            case 1:
                return Menu.SEASON;
            case 2:
                return Menu.GENERAL;
            default:
                return Menu.CACHE;
        }
    }

    private static List<Category> getRandomCategory() {
        List<Category> list = new ArrayList<>();
        switch (ThreadLocalRandom.current().nextInt(1, 3 + 1)) {
            case 1:
                list.add(Category.MEAT);
                break;
            case 2:
                list.add(Category.MEAT);
                list.add(Category.FISH);
                break;
            default:
                list.add(Category.MEAT);
                list.add(Category.FISH);
                list.add(Category.VEGETABLE);
                break;
        }
        return list;
    }

    private static Currency getRandomCurrency() {
        Random random = new Random();
        if (ThreadLocalRandom.current().nextInt(1, 100 + 1) > 50) {
            return Currency.EURO;
        } else {
            return Currency.USD;
        }
    }


    private static float getRandomFloat() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Random random = new Random();
        return Float.parseFloat(df.format(random.nextFloat()).replace(",", "."));
    }

    public static Image getRandomImage() {
        int r = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        if (r <33){
            return new Image("/sample/b1.jpg");
        } else if (r<66){
            return new Image("/sample/b2.jpg");
        } else {
            return new Image("/sample/b3.jpg");
        }

    }

    private static String getRandomString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


}
