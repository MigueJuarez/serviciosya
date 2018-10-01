package com.capgemini.spring.data.jpa.test;

import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import com.capgemeini.serviciosya.dao.ICountryDao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class CountryRepositoryTest {

    @Autowired
    private ICountryDao repository;

    private final Logger logger = LoggerFactory.getLogger (CountryRepositoryTest.class);

    public CountryRepositoryTest() {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity (Integer.valueOf(1),  "Argentina"),
                new CountryEntity (Integer.valueOf (2), "Venezuela"),
                new CountryEntity (Integer.valueOf (3), "Uruguay"),
                new CountryEntity (Integer.valueOf (4), "Chile"),
                new CountryEntity (Integer.valueOf (5), "Peru")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repository.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));
    }

    @Test
    public void testCount () {

        logger.info ("Counting countries...");
        Long count = this.repository.count ();

        Assert.assertNotNull ("There are countries...", count);
        Assert.assertTrue ("There are countries...",count > 0);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting countries...");
        List<CountryEntity> list = this.repository.findAll ();

        Assert.assertNotNull ("There are countries...", list);
        Assert.assertFalse ("There are countries...",list.isEmpty ());
    }


    @Test
    public void testGetAllLess () {

        logger.info ("Getting countries...");
        // List<CountryEntity> list = this.repository.findAllByIdIsLessThan2 (Integer.valueOf (3));

        // Assert.assertNotNull ("There are countries...", list);
        // Assert.assertFalse ("There are countries...",list.isEmpty ());
    }


    @Test
    public void testGetOne () {

        logger.info ("Getting countries...");
        CountryEntity country = this.repository.findOne (Integer.valueOf (1));

        Assert.assertNotNull ("There is a country...", country);
        Assert.assertEquals ("There is country...", "Argentina", country.getName ());
    }

    @Test
    public void testRelease () {

        logger.info ("Deleting countries...");
        this.repository.deleteAll ();
        logger.info ("Countries deleted...");

        logger.info ("Getting countries...");
        List<CountryEntity> list = this.repository.findAll ();

        Assert.assertTrue ("There are not countries...",(list).isEmpty ());
    }
}
