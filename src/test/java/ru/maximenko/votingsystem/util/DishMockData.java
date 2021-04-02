package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Dish;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class DishMockData {

    public static final int DISH1_ID = START_SEQ + 8;
    public static final int DISH2_ID = DISH1_ID + 1;
    public static final int DISH3_ID = DISH2_ID + 1;
    public static final int DISH4_ID = DISH3_ID + 1;
    public static final int DISH5_ID = DISH4_ID + 1;
    public static final int DISH6_ID = DISH5_ID + 1;
    public static final int DISH7_ID = DISH6_ID + 1;
    public static final int DISH_NOT_FOUND = START_SEQ + 576;

    public static final Dish dish1 = new Dish(DISH1_ID, "Ham & mushrooms pizza", false);
    public static final Dish dish2 = new Dish(DISH2_ID, "Pasta", false);
    public static final Dish dish3 = new Dish(DISH3_ID, "Apple Pie", false);
    public static final Dish dish4 = new Dish(DISH4_ID, "Cappuccino", false);
    public static final Dish dish5 = new Dish(DISH5_ID, "Doughnut with strawberry glaze", false);
    public static final Dish dish6 = new Dish(DISH6_ID, "Hot chocolate", false);
    public static final Dish dish7 = new Dish(DISH7_ID, "Doughnut with banana filling", false);

    public static Dish getNew() {
        return new Dish(null, "Beefsteak", false);
    }

    public static Dish getUpdated() {
        Dish updDish = new Dish(dish2);
        updDish.setName("Pasta with seafood");
        return updDish;
    }
}
