package com.capgemini.serviciosya.dao.spring.serviceSpringImpl;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.dao.spring.CountryDAOSpring;
import com.capgemini.serviciosya.dao.spring.serviceSpringInterface.CountryDAOSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryDAOSpringServiceImpl implements CountryDAOSpringService {

    @Autowired
    private CountryDAOSpring countryDAOSpring;

    @Override
    public void addCountry(CountryEntity country) {
        countryDAOSpring.add(country);
    }

    @Override
    public void deleteCountry(CountryEntity country) {
        countryDAOSpring.delete(country);
    }

    @Override
    public CountryEntity searchById(Integer id) {
        return countryDAOSpring.searchById(id);
    }

    @Override
    public List<CountryEntity> findAll() {
        return countryDAOSpring.findAll();
    }
}
