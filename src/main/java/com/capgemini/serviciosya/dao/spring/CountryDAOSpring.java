package com.capgemini.serviciosya.dao.spring;

import com.capgemini.serviciosya.beans.entity.CountryEntity;

import java.util.List;

public interface CountryDAOSpring {

    public void add(CountryEntity country);
    public void delete(CountryEntity country);
    public List<CountryEntity> findAll();
    public CountryEntity searchById(Integer id);
}
