package ru.maximenko.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant() {}
}
