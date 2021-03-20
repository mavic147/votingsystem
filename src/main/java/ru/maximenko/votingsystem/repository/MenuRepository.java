package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Menu;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer>, CustomizedMenuDeletion {

    @Query("SELECT m.dishName, m.dishPrice FROM Menu m WHERE m.restaurantId =: restaurantId AND m.deleted = false")
    List<Menu> findDishesByRestaurantId(@Param("restaurantIdt") int restaurantId);

    Optional<Menu> findByIdAndRestaurantId(int id, int restaurantId);
}
