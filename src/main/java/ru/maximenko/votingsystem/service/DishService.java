package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.Dish;
import ru.maximenko.votingsystem.repository.DishRepository;

import java.util.List;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;

@Service
public class DishService {

    private DishRepository dishRepository;

    @Autowired
    public void setDishRepository(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish get(int id) {
        return checkNotFoundById(dishRepository.findById(id).orElse(null), id);
    }

    public Dish getByName(String name) {
        Assert.notNull(name, "Name must not be null!");
        return checkNotFound(dishRepository.findByName(name), "name = " + name);
    }

    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    public boolean delete(int id) {
        return checkNotFoundById(dishRepository.delete(id), id) != 0;
    }

    public Dish create(Dish dish) {
        Assert.notNull(dish, "Dish must not be null!");
        return dishRepository.save(dish);
    }

    public Dish update(Dish dish) {
        Assert.notNull(dish, "Dish must not be null!");
        if (!dish.isNew() && get(dish.getId()) == null) {
            return null;
        }
        return dishRepository.save(dish);
    }
}
