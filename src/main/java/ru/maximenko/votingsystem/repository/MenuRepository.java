package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Menu;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.restaurantId =:restId")
    List<Menu> findDishesByRestaurantId(@Param("restId") int restaurantId);

    @Query("SELECT m FROM Menu m WHERE m.id =:id AND m.restaurantId =:restaurantId")
    Optional<Menu> findByIdAndRestaurantId(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Menu m WHERE m.id =:id AND m.restaurantId =:restaurantId")
    int delete(@Param("id") int id, @Param("restaurantId") int restaurantId);
}
