package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.maximenko.votingsystem.model.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {

    Dish findByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id =: id")
    int delete(@Param("id") int id);

    @Query("SELECT m.dishPrice FROM Menu m WHERE m.idRestaurant =: idRestaurant AND m.dishName =: dishName")
    Double getPrice(int idRestaurant, String dishName);
}
