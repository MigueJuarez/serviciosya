package com.capgemini.serviciosya.dao.service;

import com.capgemini.serviciosya.beans.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    void createCountry(CountryEntity country);
    CountryEntity getCountryById(Integer id);
    CountryEntity getCountryByCountry(CountryEntity country);
    void upgradeCountry(CountryEntity country);
    void deleteCountry(CountryEntity country);
    void deleteCountryById(Integer id);
    List<CountryEntity> getAllCountries();
}
