package ru.maximenko.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AbstractNamedEntity {

    public Role() {}

    public Role(Integer id, String name) {
        super(id, name);
    }

}
