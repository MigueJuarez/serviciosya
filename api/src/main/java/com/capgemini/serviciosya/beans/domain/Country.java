package com.capgemini.serviciosya.beans.domain;

public class Country {

    private Integer id;
    private String name;

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {
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

    @Override
    public String toString() {
        return "Country: " + name ;
    }
}
