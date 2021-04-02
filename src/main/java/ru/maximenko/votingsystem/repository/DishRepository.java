package ru.maximenko.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maximenko.votingsystem.model.Dish;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer>, CustomizedDishDeletion {

    @Query("SELECT d FROM Dish d WHERE d.id =:id AND d.deleted = false")
    Optional<Dish> findById(@Param("id") int id);
}
