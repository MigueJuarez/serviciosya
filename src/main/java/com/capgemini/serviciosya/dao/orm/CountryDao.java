package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.ICountryDao;
import com.capgemini.serviciosya.dao.daoException.DaoException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.mapping.Set;

import javax.naming.NameAlreadyBoundException;

public class CountryDao implements ICountryDao <CountryEntity,Integer> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();
    private static final Logger logger= Logger.getLogger (String.valueOf(CountryDao.class));

    @Override
    public void create(CountryEntity target) {
        // Validate the arguments.
        if (target == null) {

            logger.warn ("Country object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Creating new country %s", target));
            session.save (target);
            tx.commit ();
            logger.info (String.format ("New country %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new country %s", target));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete(CountryEntity country) {
        if (country == null) {

            logger.warn ("Country object for delete is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Deleting country %s", country));
            session.delete (country);
            tx.commit ();
            logger.info (String.format ("Country %s deleted!", country));

        } catch (Exception e) {

            logger.error (String.format ("Error deleting country %s", country));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public CountryEntity searchById(Integer id) {

        if (id == null) {

            logger.warn ("Country id is null!");
            return null;
        }

        Session session = null;
        CountryEntity country = new CountryEntity();

        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            country.setId(id);
            logger.info (String.format ("Searching country %s", id));
            country = (CountryEntity) session.get(country.getClass(),id);
            logger.info (String.format ("Country %s found!", id));

        } catch (Exception e) {

            logger.error (String.format ("Error searching country %s", id));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return country;
    }

    @Override
    public List<CountryEntity> findAll() {

        Session session = null;
        List <CountryEntity> countries = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.info (String.format ("Searching countries %s"));

            countries = (List<CountryEntity>) session.createCriteria (CountryEntity.class).list ();
            logger.info (String.format ("List countries found!"));

        } catch (Exception e) {

            logger.error (String.format ("Error searching list o countries"));

            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return countries;
    }

    @Override
    public CountryEntity findByName(String name) {

        if (name == null) {

            logger.warn ("Country name is null!");
            return null;
        }

        Session session = null;
        CountryEntity country = new CountryEntity();
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.info (String.format ("Searching country %s",name));
            Query query = session.getNamedQuery("CountryFindByName").setString("name",name);
            country = (CountryEntity) query.uniqueResult();
            logger.info (String.format ("Country %s found!",name));

        } catch (Exception e) {

            logger.error (String.format ("Error searching list o countries"));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return country;
    }

    @Override
    public void update(CountryEntity country) {

        if (country == null) {

            logger.warn ("Country is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Updating country %s ...",country.getId()));
            session.update(country);
            tx.commit ();
            logger.info (String.format ("Country %s update!",country.getId()));

        } catch (Exception e) {

            logger.error (String.format ("Error updating country %s",country.getId()));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
