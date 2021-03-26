package ru.maximenko.votingsystem.util;

import ru.maximenko.votingsystem.model.Restaurant;

import static ru.maximenko.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class RestaurantMockData {

    public static final int RESTAURANT1_ID = START_SEQ + 6;
    public static final int RESTAURANT2_ID = RESTAURANT1_ID + 1;

    public static final Restaurant rest1 = new Restaurant(RESTAURANT1_ID, "Il Patio");
    public static final Restaurant rest2 = new Restaurant(RESTAURANT2_ID, "Doughnuts & Coffee");

    public static Restaurant getNew() {
        return new Restaurant(null, "Vinoterra");
    }

    public static Restaurant getUpdated() {
        Restaurant updRest = new Restaurant(rest2);
        updRest.setName("Starbucks");
        return updRest;
    }
}
