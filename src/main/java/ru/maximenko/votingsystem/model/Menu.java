package ru.maximenko.votingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
public class Menu extends AbstractBaseEntity {

    @Column(name = "id_restaurant", nullable = false)
    @NotNull
    private int restaurantId;

    @Column(name = "name_dish", nullable = false)
    @NotBlank
    private String dishName;

    @Column(name = "price_dish", nullable = false)
    @NotNull
    private Double dishPrice;

    @Column(name = "date_last", nullable = false)
    @NotNull
    private LocalDate dateChange;

    @Column(name = "deleted", nullable = false)
    @NotNull
    private boolean deleted;

    public Menu(Menu menu) {
        this(menu.getId(), menu.getRestaurantId(), menu.getDishName(), menu.getDishPrice(), menu.getDateChange(), menu.isDeleted());
    }

    public Menu(Integer id, int restaurantId, String dishName, Double dishPrice, LocalDate dateChange, boolean deleted) {
        super(id);
        this.restaurantId = restaurantId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dateChange = dateChange;
        this.deleted = deleted;
    }

    public Menu() {}

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
