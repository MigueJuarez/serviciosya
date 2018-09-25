package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.CountryRepository;
import com.capgemini.serviciosya.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryEntity createCountry(CountryEntity country) {
        return countryRepository.save(country);
    }

    @Override
    public CountryEntity getCountry(Integer id) {
        return countryRepository.findOne(id);
    }

    @Override
    public CountryEntity upgradeCountry(CountryEntity country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(CountryEntity country) {
        countryRepository.delete(country);
    }

    @Override
    public void deleteCountry(Integer id) {
        countryRepository.delete(id);
    }

    @Override
    public List getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public long countCountries() {
        return countryRepository.count();
    }
}