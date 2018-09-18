package com.capgemini.serviciosya.dao.spring.serviceSpringInterface;

import com.capgemini.serviciosya.beans.entity.CountryEntity;

import java.util.List;

public interface CountryDAOSpringService {

    public void addCountry(CountryEntity country);
    public void deleteCountry(CountryEntity country);
    public CountryEntity searchById(Integer id);
    public List<CountryEntity> findAll();
}
