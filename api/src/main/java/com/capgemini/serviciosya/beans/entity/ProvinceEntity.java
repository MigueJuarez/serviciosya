package com.capgemini.serviciosya.beans.entity;

import com.capgemini.serviciosya.repository.ProvinceRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProvinceEntity{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer country;

    public ProvinceEntity() {
    }

    public ProvinceEntity(String name, Integer country) {
        this.name = name;
        this.country = country;
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

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ProvinceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
