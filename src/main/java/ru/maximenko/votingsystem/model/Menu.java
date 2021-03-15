package ru.maximenko.votingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
public class Menu extends AbstractBaseEntity {

    @Column(name = "id_restaurant", nullable = false)
    @NotNull
    private int idRestaurant;

    @Column(name = "id_dish", nullable = false)
    @NotNull
    private int idDish;

    @Column(name = "price_dish", nullable = false)
    @NotNull
    private Double dishPrice;

    @Column(name = "date_last", nullable = false)
    @NotNull
    private LocalDate dateChange;

    public Menu(Integer id, Double dishPrice, LocalDate dateChange) {
        super(id);
        this.dishPrice = dishPrice;
        this.dateChange = dateChange;
    }

    public Menu() {}

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
