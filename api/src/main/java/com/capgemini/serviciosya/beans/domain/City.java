package com.capgemini.serviciosya.beans.domain;

public class City {

    private Integer id;
    private String name;
    private Province province;

    public City() {
        super();
    }

    public City(Integer id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City:" + name;
    }
}
