package ru.maximenko.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.maximenko.votingsystem.util.EntityNotFoundException;
import ru.maximenko.votingsystem.model.Restaurant;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.maximenko.votingsystem.util.RestaurantMockData.*;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    protected RestaurantService restaurantService;

    @Test
    public void getOne() {
       Restaurant actualRest =  restaurantService.get(RESTAURANT1_ID);
       assertThat(actualRest).usingRecursiveComparison().isEqualTo(rest1);
    }

    @Test
    public void create() {
        Restaurant actualCreatedRest = restaurantService.create(getNew());
        Restaurant expectedCreatedRest = getNew();
        int createdRestId = actualCreatedRest.getId();
        expectedCreatedRest.setId(createdRestId);
        assertThat(actualCreatedRest).usingRecursiveComparison().isEqualTo(expectedCreatedRest);
        assertThat(restaurantService.get(createdRestId)).usingRecursiveComparison().isEqualTo(expectedCreatedRest);
    }

    @Test
    public void update() {
        restaurantService.update(getUpdated());
        assertThat(restaurantService.get(RESTAURANT2_ID)).usingRecursiveComparison().isEqualTo(getUpdated());
    }

    @Test
    public void delete() {
        restaurantService.delete(RESTAURANT2_ID);
        assertThrows(EntityNotFoundException.class, () -> restaurantService.get(RESTAURANT2_ID));
    }

    @Test
    public void deleteNotFound() {
        restaurantService.delete(RESTAURANT2_ID);
        assertThrows(EntityNotFoundException.class, () -> restaurantService.delete(RESTAURANT2_ID));
    }

}