package ru.maximenko.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.maximenko.votingsystem.model.Dish;
import ru.maximenko.votingsystem.util.EntityNotFoundException;

import static org.junit.Assert.*;
import static ru.maximenko.votingsystem.util.DishMockData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    private DishService dishService;

    @Test
    public void getOne() {
        Dish actualDish = dishService.get(DISH1_ID);
        assertThat(actualDish).usingRecursiveComparison().isEqualTo(dish1);
    }

    @Test
    public void delete() {
        dishService.delete(DISH7_ID);
        assertThrows(EntityNotFoundException.class, () -> dishService.get(DISH7_ID));
    }

    @Test
    public void deleteNotFound() {
        dishService.delete(DISH6_ID);
        assertThrows(EntityNotFoundException.class, () -> dishService.delete(DISH6_ID));
        assertThrows(EntityNotFoundException.class, () -> dishService.get(DISH_NOT_FOUND));
    }

    @Test
    public void create() {
        Dish newActual = dishService.create(getNew());
        Dish newExpected = getNew();
        int newId = newActual.getId();
        newExpected.setId(newId);
        assertThat(newActual).usingRecursiveComparison().isEqualTo(newExpected);
        assertThat(dishService.get(newId)).usingRecursiveComparison().isEqualTo(newExpected);
    }

    @Test
    public void update() {
        dishService.update(getUpdated());
        assertThat(dishService.get(DISH2_ID)).usingRecursiveComparison().isEqualTo(getUpdated());
    }
}