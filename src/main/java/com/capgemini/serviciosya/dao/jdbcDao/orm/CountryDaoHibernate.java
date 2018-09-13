package com.capgemini.serviciosya.dao.jdbcDao.orm;

import com.capgemini.serviciosya.beans.domain.entity.CountryEntity;
import com.capgemini.serviciosya.dao.daoException.DaoException;
import com.capgemini.serviciosya.dao.interfaceDao.ITablesDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.logging.Logger;

public class CountryDaoHibernate implements ITablesDao<CountryEntity,String> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();
    private static final Logger logger= Logger.getLogger (String.valueOf(CountryDaoHibernate.class));

    @Override
    public void create(CountryEntity target) {
        // Validate the arguments.
        if (target == null) {

            logger.warning ("Country object is null!");
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

            logger.info (String.format ("Error creating new country %s", target));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public List<CountryEntity> findAllOccupations() {
        return null;
    }

    @Override
    public void add(CountryEntity object) {

    }

    @Override
    public void delete(CountryEntity object) {

    }

    @Override
    public CountryEntity searchById(String id) {
        return null;
    }


    @Override
    public void update(String id, CountryEntity object) {

    }


}
