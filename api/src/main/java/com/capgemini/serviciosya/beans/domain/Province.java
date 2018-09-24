package com.capgemini.serviciosya.beans.domain;

public class Province {

    private Integer id;
    private String name;
    private Country country;

    public Province(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Province() {
        super();
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Province:" + name;
    }
}
