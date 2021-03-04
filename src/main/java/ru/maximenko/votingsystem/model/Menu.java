package ru.maximenko.votingsystem.model;

import java.time.LocalDate;

public class Menu extends AbstractBaseEntity{

    private Double dishPrice;

    private LocalDate dateChange;

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
