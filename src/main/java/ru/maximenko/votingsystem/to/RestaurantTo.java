package ru.maximenko.votingsystem.to;

/**
 * This entity will be taken to the view layer
 * */
public class RestaurantTo {

    private Integer id;

    private String name;

    private Double rating;

    public RestaurantTo(Integer id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public RestaurantTo getRestaurantTo(int id, String name, Double rating) {
        return new RestaurantTo(id, name, rating);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
