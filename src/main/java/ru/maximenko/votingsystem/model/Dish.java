package ru.maximenko.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    public Dish(Integer id, String name) {
        super(id, name);
    }

    public Dish() {}
}
