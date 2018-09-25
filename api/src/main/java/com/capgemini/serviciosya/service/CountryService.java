package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.CountryEntity;

import java.util.List;

public interface CountryService {

    CountryEntity createCountry(CountryEntity country);
    CountryEntity getCountry(Integer id);
    CountryEntity upgradeCountry(CountryEntity country);
    void deleteCountry(CountryEntity country);
    void deleteCountry(Integer id);
    List getAllCountries();
    long countCountries();
}
