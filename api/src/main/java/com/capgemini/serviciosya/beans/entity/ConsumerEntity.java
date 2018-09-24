package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity(name = "Consumer")
@Table(name = "consumer")
public class ConsumerEntity {

    @Id
    @GeneratedValue
    @Column (name = "id",nullable = false,insertable = false,updatable = false)
    private int id;

    @Column (name = "name",nullable = false,length = 48)
    private String name;

    @Column (name = "lastName",nullable = false,length = 48)
    private String lastName;

    @Column (name = "phone",nullable = false,length = 12,unique = true)
    private String phone;

    @Column (name = "dni", nullable = false, unique = true)
    private Integer dni;

    @Column (name = "email", length = 128, nullable = false, unique = true)
    @Size(min = 15, max = 100)
    private String email;

    @Column (name = "address", length = 128, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="city_id")
    private CityEntity city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
