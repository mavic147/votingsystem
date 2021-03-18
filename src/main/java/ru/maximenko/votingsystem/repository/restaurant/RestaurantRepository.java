package ru.maximenko.votingsystem.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Restaurant;

import java.time.LocalDate;

@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    int deleteById(int id);

    @Query("SELECT AVG(r.assessment) FROM Rating r WHERE r.idRestaurant =: idRestaurant AND r.dateCreate =: dateCreate")
    Double countRating(@Param("idRestaurant") int id, @Param("dateCreate") LocalDate date);

}
