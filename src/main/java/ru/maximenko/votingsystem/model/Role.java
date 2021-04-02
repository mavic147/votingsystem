package ru.maximenko.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "roles_unique_name_idx"))
public class Role extends AbstractNamedEntity {

    public Role() {}

    public Role(Integer id, String name) {
        super(id, name);
    }

}
