package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.Restaurant;
import ru.maximenko.votingsystem.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant get(int id) {
        return checkNotFoundById(restaurantRepository.findById(id).orElse(null), id);
    }

    public Restaurant getByName(String name) {
        Assert.notNull(name, "Name must not be null!");
        return checkNotFound(restaurantRepository.findByName(name), "name = " + name);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant must not be null!");
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant must not be null!");
        if (!restaurant.isNew() && get(restaurant.getId()) == null) {
            return null;
        }
        return restaurantRepository.save(restaurant);
    }

    public boolean delete(int id) {
        return checkNotFoundById(restaurantRepository.deleteById(id), id) != 0;
    }

    //this method will be invoked from controller layer with RestaurantService object
    public Double getRating(int restaurantId, LocalDate dateCreate) {
        return checkNotFoundById(restaurantRepository.countRating(restaurantId, dateCreate), restaurantId);
    }
}
