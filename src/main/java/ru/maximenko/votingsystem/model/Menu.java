package ru.maximenko.votingsystem.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu", uniqueConstraints = @UniqueConstraint(columnNames = {"id_restaurant", "id_dish"}, name = "menu_unique_dish_idx"))
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Menu extends AbstractBaseEntity {

    @Column(name = "id_restaurant", nullable = false)
    @NotNull
    private int restaurantId;

    @Column(name = "id_dish", nullable = false)
    @NotNull
    private int dishId;

    @Column(name = "price_dish", nullable = false)
    @NotNull
    private Double dishPrice;

    @Column(name = "date_last", nullable = false)
    @NotNull
    private LocalDate dateChange;

    public Menu(Menu menu) {
        this(menu.getId(), menu.getRestaurantId(), menu.getDishId(), menu.getDishPrice(), menu.getDateChange());
    }

    public Menu(Integer id, int restaurantId, int dishId, Double dishPrice, LocalDate dateChange) {
        super(id);
        this.restaurantId = restaurantId;
        this.dishId = dishId;
        this.dishPrice = dishPrice;
        this.dateChange = dateChange;
    }

    public Menu() {}

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public LocalDate getDateChange() {
        return dateChange;
    }

    public void setDateChange(LocalDate dateChange) {
        this.dateChange = dateChange;
    }

}
