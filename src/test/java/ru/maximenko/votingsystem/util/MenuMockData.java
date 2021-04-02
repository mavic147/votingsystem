package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Menu;

import java.time.LocalDate;
import java.util.List;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT1_ID;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT2_ID;
import static ru.maximenko.votingsystem.util.DishMockData.*;

public class MenuMockData {

    public static final int ITEM1_ID = START_SEQ + 15;
    public static final int ITEM2_ID = ITEM1_ID + 1;
    public static final int ITEM3_ID = ITEM2_ID + 1;
    public static final int ITEM4_ID = ITEM3_ID + 1;
    public static final int ITEM5_ID = ITEM4_ID + 1;
    public static final int ITEM6_ID = ITEM5_ID + 1;
    public static final int ITEM7_ID = ITEM6_ID + 1;
    public static final int NOT_FOUND = START_SEQ + 750;

    public static final Menu item1 = new Menu(ITEM1_ID, RESTAURANT1_ID, DISH1_ID, 600d,
            LocalDate.now());
    public static final Menu item2 = new Menu(ITEM2_ID, RESTAURANT1_ID, DISH2_ID, 580d,
            LocalDate.now());
    public static final Menu item3 = new Menu(ITEM3_ID, RESTAURANT1_ID, DISH3_ID, 340d,
            LocalDate.now());
    public static final Menu item4 = new Menu(ITEM4_ID, RESTAURANT2_ID, DISH4_ID,
            368d, LocalDate.now());
    public static final Menu item5 = new Menu(ITEM5_ID, RESTAURANT2_ID, DISH5_ID,
            150d, LocalDate.now());
    public static final Menu item6 = new Menu(ITEM6_ID, RESTAURANT2_ID, DISH6_ID,
            315d, LocalDate.now());
    public static final Menu item7 = new Menu(ITEM7_ID, RESTAURANT2_ID, DISH7_ID,
            165d, LocalDate.now());

    public static final List<Menu> rest1Menu = List.of(item1, item2, item3);
    public static final List<Menu> rest2Menu = List.of(item4, item5, item6, item7);

    public static Menu getNew() {
        return new Menu(null, RESTAURANT1_ID, DISH4_ID, 390d, LocalDate.now());
    }

    public static Menu getUpdated() {
        Menu updMenu = new Menu(item2);
        updMenu.setDishPrice(625d);
        return updMenu;
    }
}
