package com.capgemini.serviciosya.dao.test.orm;



import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.IProvinceDao;
import com.capgemini.serviciosya.dao.orm.ProvinceDao;
import org.junit.Assert;
import org.junit.Test;



public class ProvinceDaoTest {

    private IProvinceDao dao = new ProvinceDao();

    @Test
    public void testCreate () {

        ProvinceEntity p = new ProvinceEntity ();
        CountryEntity c = new CountryEntity ();
        c.setId (3);
        p.setName ("CABA");
        p.setCountry (c);

        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new Province.", c.getId ());
    }

    @Test
    public void testUpdate () {

        ProvinceEntity p = new ProvinceEntity ();
        CountryEntity c = new CountryEntity ();
        c.setId (3);
        p.setId (2);
        p.setName ("caba");
        p.setCountry (c);
        this.dao.update (p);

        Assert.assertEquals ("Failure updating Province.", "caba", p.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        ProvinceEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Province.", c);
    }

    @Test
    public void testFindAll () {

        List<ProvinceEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + " -> " + e.getCountry ().getName ()));

        Assert.assertFalse ("Failure find all provinces.", list.isEmpty ());
    }
}