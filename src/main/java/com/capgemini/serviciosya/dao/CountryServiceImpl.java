package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.dao.repository.ICountryRepository;
import com.capgemini.serviciosya.dao.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public void createCountry(CountryEntity country) {
        countryRepository.save(country);
    }

    @Override
    public CountryEntity getCountryById(Integer id) {
        return countryRepository.getOne(id);
    }

    @Override
    public CountryEntity getCountryByCountry(CountryEntity country) {
        return countryRepository.getOne(country.getId());
    }

    @Override
    public void upgradeCountry(CountryEntity country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteCountry(CountryEntity country) {
        countryRepository.delete(country.getId());
    }

    @Override
    public void deleteCountryById(Integer id) {
        countryRepository.delete(id);
    }

    @Override
    public List<CountryEntity> getAllCountries() {
        return countryRepository.findAll();
    }
}
