package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT_ID;

public class MenuMockData {

    public static final int MENU_ID = START_SEQ + 8;

    public static final Menu dish1 = new Menu(MENU_ID, RESTAURANT_ID, "Ham & mushrooms pizza", 600d,
            LocalDate.now(), false);
    public static final Menu dish2 = new Menu(MENU_ID + 1, RESTAURANT_ID, "Pasta", 580d,
            LocalDate.now(), false);
    public static final Menu dish3 = new Menu(MENU_ID + 2, RESTAURANT_ID, "Apple Pie", 340d,
            LocalDate.now(), false);
    public static final Menu dish4 = new Menu(MENU_ID + 3, RESTAURANT_ID + 1, "Cappuccino",
            368d, LocalDate.now(), false);
    public static final Menu dish5 = new Menu(MENU_ID + 4, RESTAURANT_ID + 1, "Doughnut with strawberry glaze",
            150d, LocalDate.now(), false);
    public static final Menu dish6 = new Menu(MENU_ID + 5, RESTAURANT_ID + 1, "Hot chocolate",
            315d, LocalDate.now(), false);
    public static final Menu dish7 = new Menu(MENU_ID + 6, RESTAURANT_ID + 1, "Doughnut with banana filling",
            165d, LocalDate.now(), false);

    public static final List<Menu> rest1Menu = List.of(dish1, dish2, dish3);
    public static final List<Menu> rest2Menu = List.of(dish4, dish5, dish6, dish7);

    public static Menu getNew() {
        return new Menu(null, RESTAURANT_ID, "Green salad with mozarella", 499d, LocalDate.now(), false);
    }

    public static Menu getUpdated() {
        Menu updMenu = new Menu(dish2);
        updMenu.setDishName("Pasta with seafood");
        updMenu.setDishPrice(625d);
        return updMenu;
    }

}
