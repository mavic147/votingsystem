package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Menu;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m.dishName, m.dishPrice FROM Menu m WHERE m.idRestaurant =: restaurantId AND m.deleted = false")
    List<Menu> findDishesByRestaurantId(@Param("restaurantId")int restaurantId);

    Optional<Menu> findByIdAndIdRestaurant(int id, int restaurantId);
}