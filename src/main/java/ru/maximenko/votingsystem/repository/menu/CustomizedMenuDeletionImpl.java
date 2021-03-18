package ru.maximenko.votingsystem.repository.menu;

import ru.maximenko.votingsystem.model.Menu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomizedMenuDeletionImpl implements CustomizedMenuDeletion {

    @PersistenceContext
    EntityManager em;

    @Override
    public int delete(int id) {
        Menu menu = em.find(Menu.class, id);
        if (menu != null) {
            menu.setDeleted(true);
            return 1;
        }
        return 0;
    }
}
