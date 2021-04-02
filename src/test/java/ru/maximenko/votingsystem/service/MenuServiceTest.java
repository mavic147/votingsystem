package ru.maximenko.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.maximenko.votingsystem.model.Menu;
import ru.maximenko.votingsystem.util.EntityNotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static ru.maximenko.votingsystem.util.MenuMockData.*;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT1_ID;
import static ru.maximenko.votingsystem.util.RestaurantMockData.RESTAURANT2_ID;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    protected MenuService menuService;

    @Test
    public void getOne() {
        Menu actual = menuService.get(ITEM1_ID, RESTAURANT1_ID);
        assertThat(actual).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(item1);
    }

    @Test
    public void getNotOwn() {
        assertThrows(EntityNotFoundException.class, () -> menuService.get(ITEM1_ID, RESTAURANT2_ID));
    }

    @Test
    public void getAll() {
        List<Menu> actualRestMenu = menuService.getAllDishesOfOneRestaurant(RESTAURANT1_ID);
        assertThat(actualRestMenu).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(rest1Menu);
    }

    @Test
    public void create() {
        Menu actualCreated = menuService.create(getNew());
        Menu expectedCreated = getNew();
        int newId = actualCreated.getId();
        expectedCreated.setId(newId);
        assertThat(actualCreated).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(expectedCreated);
        assertThat(menuService.get(newId, RESTAURANT1_ID)).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(expectedCreated);
    }

    @Test
    public void update() {
        menuService.update(getUpdated(), RESTAURANT1_ID);
        assertThat(menuService.get(ITEM2_ID, RESTAURANT1_ID)).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(getUpdated());
    }

    @Test
    public void updateNotOwn() {
        EntityNotFoundException ex = assertThrows(EntityNotFoundException.class, () -> menuService.update(getUpdated(), RESTAURANT2_ID));
        assertEquals("Not found entity with id = " + (ITEM2_ID), ex.getMessage());
        assertThat(menuService.get(ITEM2_ID, RESTAURANT1_ID)).usingRecursiveComparison().ignoringFields("dateChange").isEqualTo(item2);
    }

    @Test
    public void delete() {
        menuService.delete(ITEM7_ID, RESTAURANT2_ID);
        assertThrows(EntityNotFoundException.class, () -> menuService.get(ITEM7_ID, RESTAURANT2_ID));
    }

    @Test
    public void deleteNotFound() {
        menuService.delete(ITEM6_ID, RESTAURANT2_ID);
        assertThrows(EntityNotFoundException.class, () -> menuService.delete(ITEM6_ID, RESTAURANT2_ID));
        assertThrows(EntityNotFoundException.class, () -> menuService.delete(NOT_FOUND, RESTAURANT2_ID));
    }

    @Test
    public void deleteNotOwn() {
        assertThrows(EntityNotFoundException.class, () -> menuService.delete(ITEM1_ID, RESTAURANT2_ID));
    }

}