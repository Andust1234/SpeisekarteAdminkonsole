package entitys;

import java.util.ArrayList;
import java.util.List;

public class DishWrapper {

    private List<Dish> dishes;

    public DishWrapper(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        if (dishes != null) {
            for (Dish dish : dishes){
                names.add(dish.getName());
            }
        }
        return names;
    }
}

