package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

import static tools.utils.StringUtils.getOnlyIntFromString;

@Getter
@Setter
@ToString
public class Seller {
    private String name;
    private int id;
    private int rate;
    private String time;
    private int rating;
    private int likes;
    private int sells;
    private String city;
    private String member;

    public void setId(String id) {
        this.id = getOnlyIntFromString(id);
    }

    public void setRate(String rate) {
        this.rate = getOnlyIntFromString(rate);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRating(String rating) {
        this.rating = getOnlyIntFromString(rating);
    }

    public void setLikes(String likes) {
        this.likes = getOnlyIntFromString(likes);
    }

    public void setSells(String sells) {
        this.sells = getOnlyIntFromString(sells);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return name.equals(seller.name) && city.equals(seller.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    public String comparableInfo() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
