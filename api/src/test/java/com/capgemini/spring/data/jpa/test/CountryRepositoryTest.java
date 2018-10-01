package com.capgemini.spring.data.jpa.test;

import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import com.capgemeini.serviciosya.dao.ICountryDao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class CountryRepositoryTest {

    @Autowired
    private ICountryDao repository = null;

    //private final Logger logger = LoggerFactory.getLogger(CountryRepositoryTest.class);

    public CountryRepositoryTest(){
        super();
    }

    @Test
    public void testTrue(){
        Assert.assertTrue(true);
    }

    @Test
    public void testAgregar(){
        CountryEntity argentina = new CountryEntity(Integer.valueOf(1),"Argentina");
        this.repository.save(argentina);
        Assert.assertTrue(true);

    }
}
