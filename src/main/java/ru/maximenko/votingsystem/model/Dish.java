package ru.maximenko.votingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dishes", uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "dish_unique_name_idx"))
public class Dish extends AbstractNamedEntity {

    @Column(name = "deleted", nullable = false)
    @NotNull
    private boolean deleted;

    public Dish() {}

    public Dish(Integer id, String name, @NotNull boolean deleted) {
        super(id, name);
        this.deleted = deleted;
    }

    public Dish(Dish dish) {
        this(dish.getId(), dish.getName(), dish.isDeleted());
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
