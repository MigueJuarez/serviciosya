package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.dao.repository.CountryRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryTest {

    @Autowired
    private CountryRepository repository = null;

    public CountryTest(){
        super();
    }

    @Test
    public void createCountryTest(){

        CountryEntity country = new CountryEntity(1,"Argentina");
        Assert.assertTrue(true);
    }
}
