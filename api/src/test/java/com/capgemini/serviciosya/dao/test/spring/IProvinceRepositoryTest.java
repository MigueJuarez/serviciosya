package com.capgemini.serviciosya.dao.test.spring;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.repository.ProvinceRepository;
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
public class IProvinceRepositoryTest {

    @Autowired
    private ProvinceRepository repository = null;

    private final Logger logger = LoggerFactory.getLogger (IProvinceRepositoryTest.class);

    public IProvinceRepositoryTest() {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity[]{
            new ProvinceEntity("Buenos Aires",Integer.valueOf(1))
        };
        logger.debug (String.format ("Objects provinces created %s", Arrays.toString (provinces)));

        logger.debug ("Saving provinces...");
        this.repository.save (Arrays.asList (provinces));
        logger.debug (String.format ("Provinces saved %s", Arrays.toString (provinces)));
    }

    @Test
    public void addProviderTest(){
        ProvinceEntity p = new ProvinceEntity ("La Pampa",Integer.valueOf(1));
        long cantProvinces = this.repository.count();

        this.repository.save(p);

        Assert.assertEquals(cantProvinces+1,this.repository.count());
    }

    @After
    public void deleteUsages(){
        logger.debug("Deleting provinces after tests");
        this.repository.deleteAll();
        logger.debug("Table Province clear");
    }
}
