package com.capgemini.serviciosya.dao.test.jdbc;


import com.capgemini.serviciosya.beans.domain.OccupationEntity;
import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.jdbc.OccupationDaoJDBC;
import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class OccupationEntityServiceTest {


    private static final Logger logger = Logger.getLogger (OccupationEntityServiceTest.class);


    @Test
    public void testAdd () {

        try {

            // Insert new value.
            logger.info ("Starting occupation add test.");
            IOccupationDao dao = new OccupationDaoJDBC();

            logger.debug ("Inserting new occupation.");
            OccupationEntity c = new OccupationEntity();
            c.setName ("Rum Tester.");
            c.setDescription ("xxxx");
            dao.create (c);

            logger.debug ("Checking test result.");
            List<OccupationEntity> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (OccupationEntity item: list) {

                if (item.getName ().equals (c.getName ())) {
                    r = Boolean.TRUE;
                    break;
                }
            }

            logger.info ("Finishing the test...");
            Assert.assertTrue ("Failure inserting new OccupationEntity.", r);


        } catch (Exception e) {

            Assert.assertNull (e);
        }
    }

}