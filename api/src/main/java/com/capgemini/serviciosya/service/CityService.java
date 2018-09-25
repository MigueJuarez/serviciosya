package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.CityEntity;

import java.util.List;


public interface CityService {

    public void createCity(CityEntity city);
    public void deleteCity(CityEntity city);
    public List<CityEntity> findAll();
    public CityEntity getCity(Integer id);
}
