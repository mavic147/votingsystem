package ru.maximenko.votingsystem.model;

public class Dish extends AbstractNamedEntity{

    private Double price;

    public Dish(Integer id, String name, Double price) {
        super(id, name);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
