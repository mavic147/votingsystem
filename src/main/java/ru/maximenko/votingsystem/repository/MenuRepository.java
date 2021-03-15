package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Menu;

import java.util.List;

@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("DELETE FROM Menu m WHERE m.id = :id")
    @Transactional
    @Modifying
    int deleteById(int id);

    @Query("SELECT m.id, m.idRestaurant, m.idDish, m.dishPrice, m.dateChange " +
            "FROM Menu m WHERE m.idRestaurant =: restaurantId")
    List<Menu> findDishesByRestaurantId(int restaurantId);
}
