package com.capgemini.java.rest.country.test;

import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import com.capgemeini.serviciosya.dao.ICountryDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = PostgredbConfiguration.class)
public class MovieRepositoryTest {

    @Autowired
    private ICountryDao countryDao = null;

    public MovieRepositoryTest(){

        super();
    }

    public void testCreate(){

        CountryEntity country = new CountryEntity(10,"Japon");

        this.countryDao.save(country);

        assertNotNull("Country is null !",country.getId());


    }
}
