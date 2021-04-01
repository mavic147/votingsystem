package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT1_ID;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT2_ID;
import static ru.maximenko.votingsystem.util.DishMockData.*;

public class MenuMockData {

    public static final int MENU1_ID = START_SEQ + 15;
    public static final int MENU2_ID = MENU1_ID + 1;
    public static final int MENU3_ID = MENU2_ID + 1;
    public static final int MENU4_ID = MENU3_ID + 1;
    public static final int MENU5_ID = MENU4_ID + 1;
    public static final int MENU6_ID = MENU5_ID + 1;
    public static final int MENU7_ID = MENU6_ID + 1;
    public static final int NOT_FOUND = START_SEQ + 750;

    public static final Menu menu1 = new Menu(MENU1_ID, RESTAURANT1_ID, DISH1_ID, 600d,
            LocalDate.now());
    public static final Menu menu2 = new Menu(MENU2_ID, RESTAURANT1_ID, DISH2_ID, 580d,
            LocalDate.now());
    public static final Menu menu3 = new Menu(MENU3_ID, RESTAURANT1_ID, DISH3_ID, 340d,
            LocalDate.now());
    public static final Menu menu4 = new Menu(MENU4_ID, RESTAURANT2_ID, DISH4_ID,
            368d, LocalDate.now());
    public static final Menu menu5 = new Menu(MENU5_ID, RESTAURANT2_ID, DISH5_ID,
            150d, LocalDate.now());
    public static final Menu menu6 = new Menu(MENU6_ID, RESTAURANT2_ID, DISH6_ID,
            315d, LocalDate.now());
    public static final Menu menu7 = new Menu(MENU7_ID, RESTAURANT2_ID, DISH7_ID,
            165d, LocalDate.now());

    public static final List<Menu> rest1Menu = List.of(menu1, menu2, menu3);
    public static final List<Menu> rest2Menu = List.of(menu4, menu5, menu6, menu7);

    public static Menu getNew() {
        return new Menu(null, RESTAURANT1_ID, DISH4_ID, 390d, LocalDate.now());
    }

    public static Menu getUpdated() {
        Menu updMenu = new Menu(menu2);
        updMenu.setDishPrice(625d);
        return updMenu;
    }

}
