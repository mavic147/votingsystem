package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT1_ID;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT2_ID;

public class MenuMockData {

    public static final int MENU1_ID = START_SEQ + 8;
    public static final int MENU2_ID = MENU1_ID + 1;
    public static final int MENU3_ID = MENU2_ID + 1;
    public static final int MENU4_ID = MENU3_ID + 1;
    public static final int MENU5_ID = MENU4_ID + 1;
    public static final int MENU6_ID = MENU5_ID + 1;
    public static final int MENU7_ID = MENU6_ID + 1;
    public static final int NOT_FOUND = START_SEQ + 50;

    public static final Menu dish1 = new Menu(MENU1_ID, RESTAURANT1_ID, "Ham & mushrooms pizza", 600d,
            LocalDate.now(), false);
    public static final Menu dish2 = new Menu(MENU2_ID, RESTAURANT1_ID, "Pasta", 580d,
            LocalDate.now(), false);
    public static final Menu dish3 = new Menu(MENU3_ID, RESTAURANT1_ID, "Apple Pie", 340d,
            LocalDate.now(), false);
    public static final Menu dish4 = new Menu(MENU4_ID, RESTAURANT2_ID, "Cappuccino",
            368d, LocalDate.now(), false);
    public static final Menu dish5 = new Menu(MENU5_ID, RESTAURANT2_ID, "Doughnut with strawberry glaze",
            150d, LocalDate.now(), false);
    public static final Menu dish6 = new Menu(MENU6_ID, RESTAURANT2_ID, "Hot chocolate",
            315d, LocalDate.now(), false);
    public static final Menu dish7 = new Menu(MENU7_ID, RESTAURANT2_ID, "Doughnut with banana filling",
            165d, LocalDate.now(), false);

    public static final List<Menu> rest1Menu = List.of(dish1, dish2, dish3);
    public static final List<Menu> rest2Menu = List.of(dish4, dish5, dish6, dish7);

    public static Menu getNew() {
        return new Menu(null, RESTAURANT1_ID, "Green salad with mozarella", 499d, LocalDate.now(), false);
    }

    public static Menu getUpdated() {
        Menu updMenu = new Menu(dish2);
        updMenu.setDishName("Pasta with seafood");
        updMenu.setDishPrice(625d);
        return updMenu;
    }

}
