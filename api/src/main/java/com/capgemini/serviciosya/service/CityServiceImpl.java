package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.dao.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void createCity(CityEntity city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(CityEntity city) {
        cityRepository.delete(city);
    }

    @Override
    public List<CityEntity> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public CityEntity getCity(Integer id) {
        return cityRepository.getOne(id);
    }
}
