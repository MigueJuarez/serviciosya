package com.capgemini.serviciosya.dao.test.spring;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.repository.IProviderRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IProviderRepositoryTest {

    @Autowired
    private IProviderRepository repository = null;

    private final Logger logger = LoggerFactory.getLogger (IProviderRepositoryTest.class);

    public IProviderRepositoryTest() {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating providers...");
        ProviderEntity[] providers = new ProviderEntity[]{

                new ProviderEntity (Integer.valueOf(1),""),
                new ProviderEntity (Integer.valueOf (2), ""),
                new ProviderEntity (Integer.valueOf (3), ""),
                new ProviderEntity (Integer.valueOf (4), ""),
                new ProviderEntity (Integer.valueOf (5), "")
        };
        logger.debug (String.format ("Objects provider created %s", Arrays.toString (providers)));

        logger.debug ("Saving provider...");
        this.repository.save (Arrays.asList (providers));
        logger.debug (String.format ("Providers saved %s", Arrays.toString (providers)));
    }

    @Test
    public void addProviderTest(){
        ProviderEntity p = new ProviderEntity(Integer.valueOf(6),"");
        long cantProviders = this.repository.count();

        this.repository.add(p);

        Assert.assertEquals(cantProviders+1,this.repository.count());
    }

    @After
    public void deleteUsages(){
        logger.debug("Deleting providers after tests");
        this.repository.deleteAll();
        logger.debug("Table Provider clear");
    }
}