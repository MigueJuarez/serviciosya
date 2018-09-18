package com.capgemini.serviciosya.dao.test.spring;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.dao.spring.CountryDAOSpring;
import com.capgemini.serviciosya.dao.spring.ormSpring.CountryDAOSpringImpl;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class CountryDAOSpringImplTest {

    private CountryDAOSpring countryDAO = new CountryDAOSpringImpl();


    @Test
    public void addCountrySpringTest(){

        CountryEntity country = new CountryEntity();
        country.setName("Francia");

        countryDAO.add(country);

    }
}
