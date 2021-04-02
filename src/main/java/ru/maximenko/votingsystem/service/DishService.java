package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.Dish;
import ru.maximenko.votingsystem.repository.DishRepository;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public Dish create(Dish dish) {
        Assert.notNull(dish, "Dish must not be null!");
        return checkNotFound(dishRepository.save(dish), "dish" + dish);
    }

    public Dish update(Dish dish) {
        Assert.notNull(dish, "Dish must not be null!");
        if (!dish.isNew() && get(dish.getId()) == null) {
            return null;
        }
        return dishRepository.save(dish);
    }

    public boolean delete(int id) {
        if (dishRepository.delete(id) != 0) {
            return true;
        } else {
            get(id);
            return false;
        }
    }

    public Dish get(int id) {
        return checkNotFoundById(dishRepository.findById(id).orElse(null), id);
    }
}
