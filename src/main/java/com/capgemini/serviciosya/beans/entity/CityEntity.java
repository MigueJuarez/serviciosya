package com.capgemini.serviciosya.beans.entity;


import javax.persistence.*;

@Entity(name = "City")
@Table(name = "city")

public class CityEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "province_id")
    @Column (length = 48, nullable = false)
    private ProvinceEntity province;

    public CityEntity() {
        super();
    }

    public CityEntity(String name, ProvinceEntity province) {
        this.name = name;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    @Override
    public String toString () {

        return this.name;
    }
}
