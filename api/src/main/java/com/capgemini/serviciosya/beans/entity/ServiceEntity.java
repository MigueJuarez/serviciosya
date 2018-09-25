package com.capgemini.serviciosya.beans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer value;
    private Integer provider;
    private Integer consumer;
    private String description;

    public ServiceEntity() {
    }

    public ServiceEntity(String name, Integer value, Integer provider, Integer consumer, String description) {
        this.name = name;
        this.value = value;
        this.provider = provider;
        this.consumer = consumer;
        this.description = description;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public Integer getConsumer() {
        return consumer;
    }

    public void setConsumer(Integer consumer) {
        this.consumer = consumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
