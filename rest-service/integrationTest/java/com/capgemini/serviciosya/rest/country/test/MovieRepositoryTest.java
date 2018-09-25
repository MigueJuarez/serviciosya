package com.capgemini.serviciosya.rest.country.test;

import com.capgemini.serviciosya.rest.country.entity.Country;
import com.capgemini.serviciosya.rest.country.repository.CountryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = MongodbConfiguration.class)
public class MovieRepositoryTest {

    @Autowired
    private CountryRepository repository = null;

    public MovieRepositoryTest(){

        super();
    }

    @Test
    public void testCreate(){

        Country country = new Country();
        country.setName("Argentina");
        country.setId(1);

        this.repository.save(country);

        Assert.assertNotNull("Country not null",country.getId());
    }
}
