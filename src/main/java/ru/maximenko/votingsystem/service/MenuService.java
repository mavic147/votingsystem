package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.Menu;
import ru.maximenko.votingsystem.repository.MenuRepository;

import java.util.List;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu create(Menu menu) {
        Assert.notNull(menu, "Menu must not be null!");
        return checkNotFound(menuRepository.save(menu), "menu" + menu);
    }

    public Menu update(Menu menu, int restId) {
        Assert.notNull(menu, "Menu must not be null!");
        if (!menu.isNew() && get(menu.getId(), restId) == null) {
            return null;
        }
        return menuRepository.save(menu);
    }

    public boolean delete(int id, int restId) {
        if (menuRepository.delete(id, restId) != 0) {
            return true;
        } else {
            get(id, restId);
            return false;
        }
    }

    //returns one Menu item
    public Menu get(int id, int restaurantId) {
        return checkNotFoundById(menuRepository.findByIdAndRestaurantId(id, restaurantId).orElse(null), id);
    }

    //returns all dishes belonging to a certain restaurant
    public List<Menu> getAllDishesOfOneRestaurant(int restaurantId) {
        return checkNotFoundById(menuRepository.findDishesByRestaurantId(restaurantId), restaurantId);
    }
}
