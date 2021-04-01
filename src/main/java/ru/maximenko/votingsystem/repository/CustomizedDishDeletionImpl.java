package ru.maximenko.votingsystem.repository;

import ru.maximenko.votingsystem.model.Dish;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomizedDishDeletionImpl implements CustomizedDishDeletion {

    @PersistenceContext
    EntityManager em;

    @Override
    public int delete(int id) {
        Dish dish = em.find(Dish.class, id);
        if (dish != null && !dish.isDeleted()) {
            dish.setDeleted(true);
            return 1;
        }
        return 0;
    }
}
