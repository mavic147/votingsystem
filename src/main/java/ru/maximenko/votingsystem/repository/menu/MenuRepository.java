package ru.maximenko.votingsystem.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Menu;

import java.util.List;

@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m.dishName, m.dishPrice FROM Menu m WHERE m.idRestaurant =: restaurantId")
    List<Menu> findDishesByRestaurantId(int restaurantId);
}
