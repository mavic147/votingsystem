package ru.maximenko.votingsystem.repository;

import ru.maximenko.votingsystem.model.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {

    Dish findById(int id);
}
