package com.perraulthealth;

/**
 * Created by sutu on 11/9/2016.
 */

public class Hospital {

    private String name;
    private Integer numofbeds;
    private String address;
    private String rating;

    public Hospital() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumofbeds() {
        return numofbeds;
    }

    public void setNumofbeds(Integer numofbeds) {
        this.numofbeds = numofbeds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
