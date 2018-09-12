package com.capgemini.test.serviciosya.service.test;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.OccupationDaoMemory;
import com.capgemini.serviciosya.service.OccupationService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OccupationServiceTest {

    private OccupationService occupationService = new OccupationService();
    private IOccupationDao occupationDao = new OccupationDaoMemory();


    @Test
    public void testFindAllOccupations () {

        this.occupationService.setOccupationDao (this.occupationDao);
        List<Occupation> list = this.occupationService.findAllOccupations ();
        assertFalse (list.isEmpty ());
    }

    @Test
    public void testAddOccupation () {

        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");
        List<Occupation> init = this.occupationDao.findAllOccupations ();

        this.occupationService.addOccupation (o);

        List<Occupation> end = this.occupationDao.findAllOccupations ();

        assertTrue (init.size()+1 == end.size());
    }
    @Test
    public void deleteOccupationTest (){

        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> init = this.occupationDao.findAllOccupations ();

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        this.occupationService.addOccupation (o);

        this.occupationService.deleteOccupation(o);

        List<Occupation> end = this.occupationDao.findAllOccupations ();

        assertTrue (init.size() == end.size());

    }
    @Test
    public void searchByIdTest(){

        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        this.occupationService.addOccupation(o);

        Occupation o2 = this.occupationService.searchByIdOccupation(o.getId());

        Assert.assertTrue(o.getId().equals(o2.getId()));

    }
}
