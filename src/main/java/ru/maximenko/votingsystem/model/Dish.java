package ru.maximenko.votingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {

    public Dish() {}

    public Dish(Integer id, String name, @NotNull boolean deleted) {
        super(id, name);
        this.deleted = deleted;
    }

    public Dish(Dish dish) {
        this(dish.getId(), dish.getName(), dish.isDeleted());
    }

    @Column(name = "deleted", nullable = false)
    @NotNull
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
