package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.dao.ICityDao;
import com.capgemini.serviciosya.dao.daoException.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CityDao implements ICityDao <CityEntity,Integer> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();
    private static final Logger logger= Logger.getLogger (String.valueOf(CityDao.class));

    @Override
    public void create(CityEntity city) {
        // Validate the arguments.
        if (city == null) {

            logger.warn ("City object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Creating new city %s", city));
            session.save (city);
            tx.commit ();
            logger.info (String.format ("New city %s created!", city));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new city %s", city));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete(CityEntity city) {

        if (city == null) {

            logger.warn ("City object for delete is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Deleting new city %s", city));
            session.delete (city);
            tx.commit ();
            logger.info (String.format ("City %s deleted!", city));

        } catch (Exception e) {

            logger.error (String.format ("Error deleting city %s", city));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public CityEntity searchById(Integer id) {

        if (id == null) {

            logger.warn ("Country id is null!");
            return null;
        }

        Session session = null;
        Transaction tx = null;
        CityEntity city = new CityEntity();

        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            city.setId(id);
            logger.info (String.format ("Searching city %s", id));
            city = (CityEntity) session.get(city.getClass(),id);
            tx.commit ();
            logger.info (String.format ("City %s found!", id));

        } catch (Exception e) {

            logger.error (String.format ("Error searching city %s", id));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return city;
    }

    @Override
    public List<CityEntity> findAll() {

        Session session = null;
        List <CityEntity> city = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.info (String.format ("Searching city %s"));

            city = (List<CityEntity>) session.createCriteria (CityEntity.class).list ();
            logger.info (String.format ("List city found!"));

        } catch (Exception e) {

            logger.error (String.format ("Error searching list o city"));

            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return city;
    }

    @Override
    public void update(CityEntity city) {
        if (city == null) {

            logger.warn ("City is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Updating cityy %s ...",city.getId()));
            session.update(city);
            tx.commit ();
            logger.info (String.format ("City %s update!",city.getId()));

        } catch (Exception e) {

            logger.error (String.format ("Error updating city %s",city.getId()));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
