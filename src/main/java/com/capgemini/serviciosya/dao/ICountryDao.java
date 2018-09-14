package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.entity.CountryEntity;

import java.util.List;

public interface ICountryDao<C, I extends Number> extends IDao <CountryEntity,Integer> {

    CountryEntity findById(int id);

    List<CountryEntity> findAll();

    CountryEntity findByName(String argentina);

    void update(CountryEntity c);
}
