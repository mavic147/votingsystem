package ru.maximenko.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.maximenko.votingsystem.model.Menu;
import ru.maximenko.votingsystem.util.EntityNotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static ru.maximenko.votingsystem.util.MenuMockData.*;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT_ID;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    protected MenuService menuService;

    @Test
    public void getOne() {
        Menu actual = menuService.get(MENU_ID, RESTAURANT_ID);
        assertThat(actual).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(dish1);
    }

    @Test
    public void getNotOwn() {
        assertThrows(EntityNotFoundException.class, () -> menuService.get(MENU_ID, RESTAURANT_ID + 1));
    }

    @Test
    public void getAll() {
        List<Menu> actualRestMenu = menuService.getAllDishesOfOneRestaurant(RESTAURANT_ID);
        assertThat(actualRestMenu).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(rest1Menu);
    }

    @Test
    public void create() {
        Menu actualCreated = menuService.create(getNew());
        Menu expectedCreated = getNew();
        int newId = actualCreated.getId();
        expectedCreated.setId(newId);
        assertThat(actualCreated).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(expectedCreated);
        assertThat(menuService.get(newId, RESTAURANT_ID)).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(expectedCreated);
    }

    @Test
    public void update() {
        menuService.update(getUpdated(), RESTAURANT_ID);
        assertThat(menuService.get(MENU_ID + 1, RESTAURANT_ID)).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(getUpdated());
    }

    @Test
    public void updateNotOwn() {
        EntityNotFoundException ex = assertThrows(EntityNotFoundException.class, () -> menuService.update(getUpdated(), RESTAURANT_ID + 1));
        assertEquals("Not found entity with id = " + (MENU_ID + 1), ex.getMessage());
        assertThat(menuService.get(MENU_ID + 1, RESTAURANT_ID)).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(dish2);
    }

    @Test
    public void delete() {
        menuService.delete(MENU_ID + 6, RESTAURANT_ID + 1);
        assertThrows(EntityNotFoundException.class, () -> menuService.get(MENU_ID + 6, RESTAURANT_ID + 1));
    }

    @Test
    public void deleteNotFound() {
        menuService.delete(MENU_ID + 5, RESTAURANT_ID + 1);
        assertThrows(EntityNotFoundException.class, () -> menuService.delete(MENU_ID + 5, RESTAURANT_ID + 1));
        assertThrows(EntityNotFoundException.class, () -> menuService.delete(NOT_FOUND, RESTAURANT_ID + 1));
    }

    @Test
    public void deleteNotOwn() {
        assertThrows(EntityNotFoundException.class, () -> menuService.delete(MENU_ID, RESTAURANT_ID + 1));
    }

}