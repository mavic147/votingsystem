package ru.maximenko.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.maximenko.votingsystem.model.Menu;
import ru.maximenko.votingsystem.repository.menu.CustomizedMenuDeletionImpl;
import ru.maximenko.votingsystem.repository.menu.MenuRepository;

import java.util.List;

import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFoundById;
import static ru.maximenko.votingsystem.util.EntityValidationUtil.checkNotFound;

@Service
public class MenuService {

    private MenuRepository menuRepository;
    private CustomizedMenuDeletionImpl menuDeletion;

    @Autowired
    public void setMenuRepository(MenuRepository menuRepository, CustomizedMenuDeletionImpl menuDeletion) {
        this.menuRepository = menuRepository;
        this.menuDeletion = menuDeletion;
    }

    public Menu create(Menu menu) {
        Assert.notNull(menu, "Menu must not be null!");
        return checkNotFound(menuRepository.save(menu), "menu" + menu);
    }

    public Menu update(Menu menu) {
        Assert.notNull(menu, "Menu must not be null!");
        if (!menu.isNew() && get(menu.getId()) == null) {
            return null;
        }
        return menuRepository.save(menu);
    }

    public boolean delete(int id) {
        return checkNotFoundById(menuDeletion.delete(id), id) != 0;
    }

    //returns one Menu item
    public Menu get(int id) {
        return checkNotFoundById(menuRepository.findById(id).orElse(null), id);
    }

    //returns all dishes belonging to a certain restaurant
    public List<Menu> getAllDishesOfOneRestaurant(int restaurantId) {
        return checkNotFoundById(menuRepository.findDishesByRestaurantId(restaurantId), restaurantId);
    }
}
