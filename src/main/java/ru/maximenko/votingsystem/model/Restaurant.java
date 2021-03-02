package ru.maximenko.votingsystem.model;

import java.util.List;

public class Restaurant extends AbstractNamedEntity {

    private List<Dish> menu;

    private Integer rating;

    public Restaurant(Integer id, String name, List<Dish> menu, Integer rating) {
        super(id, name);
        this.menu = menu;
        this.rating = rating;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
