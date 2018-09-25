package com.capgemini.serviciosya.beans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProviderEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String lastName;
    private Integer dni;
    private String adress;
    private String phone;
    private String email;
    private String status;
    private Integer city;

    public ProviderEntity() {
    }

    public ProviderEntity(String name, String lastName, Integer dni, String adress, String phone, String email, String status, Integer city) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.city = city;
    }

    @Override
    public String toString() {
        return "ProviderEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }
}
