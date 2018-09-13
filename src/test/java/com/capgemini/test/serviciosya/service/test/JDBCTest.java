package com.capgemini.test.serviciosya.service.test;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.interfaceDao.ITablesDao;
import com.capgemini.serviciosya.dao.jdbcDao.OccupationJdbcDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class JDBCTest {

    private static final Logger logger = Logger.getLogger (OccupationServiceTest.class.toString());

    @Test
    public void testAdd () {

        try {

            // Insert new value.
            logger.info ("Starting occupation add test.");
            ITablesDao dao = new OccupationJdbcDao();

            logger.info ("Inserting new occupation.");
            Occupation c = new Occupation ();
            c.setName ("Encantador de suegras.");
            c.setDescription ("Amo el peligro");
            dao.add (c);

            logger.info ("Checking test result.");
            List<Occupation> list = dao.findAllOccupations ();

            boolean r = Boolean.FALSE;

            for (Occupation item: list) {

                if (item.getName ().equals (c.getName ())) {
                    r = Boolean.TRUE;
                    break;
                }
            }

            logger.info ("Finishing the test...");
            Assert.assertTrue ("Failure inserting new Occupation.", r);


        } catch (Exception e) {

            Assert.assertNull (e);
        }
    }
}
