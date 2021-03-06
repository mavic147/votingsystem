package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Restaurant;

import java.time.LocalDate;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id =:id")
    int deleteById(@Param("id") int id);

    @Query("SELECT AVG(r.assessment) FROM Rating r WHERE r.idRestaurant =: idRestaurant AND r.dateCreate =: dateCreate")
    Double countRating(@Param("idRestaurant") int id, @Param("dateCreate") LocalDate date);

}
