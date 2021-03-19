package ru.maximenko.votingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.maximenko.votingsystem.model.Menu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomizedMenuDeletionImpl implements CustomizedMenuDeletion {

    @PersistenceContext
    EntityManager em;

    @Override
    public int delete(int id, int restId) {
        Menu menu = em.find(Menu.class, id);
        if (menu != null && menu.getIdRestaurant() == restId) {
            menu.setDeleted(true);
            return 1;
        }
        return 0;
    }
}
