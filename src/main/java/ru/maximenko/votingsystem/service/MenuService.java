package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.Menu;
import ru.maximenko.votingsystem.repository.CustomizedMenuDeletion;
import ru.maximenko.votingsystem.repository.MenuRepository;

import java.util.List;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CustomizedMenuDeletion menuDeletion;

    public Menu create(Menu menu) {
        Assert.notNull(menu, "Menu must not be null!");
        return checkNotFound(menuRepository.save(menu), "menu" + menu);
    }

    public Menu update(Menu menu, int restId) {
        Assert.notNull(menu, "Menu must not be null!");
        if (!menu.isNew() && get(menu.getId(), menu.getIdRestaurant()) == null && menu.getIdRestaurant() != restId) {
            return null;
        }
        return menuRepository.save(menu);
    }

    public boolean delete(int id, int restId) {
        return checkNotFoundById(menuDeletion.delete(id, restId), id) != 0;
    }

    //returns one Menu item
    public Menu get(int id, int restaurantId) {
        return checkNotFoundById(menuRepository.findByIdAndIdRestaurant(id, restaurantId).orElse(null), id);
    }

    //returns all dishes belonging to a certain restaurant
    public List<Menu> getAllDishesOfOneRestaurant(int restaurantId) {
        return checkNotFoundById(menuRepository.findDishesByRestaurantId(restaurantId), restaurantId);
    }
}
