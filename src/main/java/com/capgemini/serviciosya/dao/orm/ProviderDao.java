package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.IProviderDao;
import com.capgemini.serviciosya.dao.daoException.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProviderDao implements IProviderDao{

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();
    private static final Logger logger= Logger.getLogger (String.valueOf(ProviderDao.class));

    @Override
    public void create(ProviderEntity provider) {
        if (provider == null) {

            logger.warn ("Consumer object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Creating new provider %s", provider));
            session.save (provider);
            tx.commit ();
            logger.info (String.format ("New provider %s created!", provider));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new provider %s", provider));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete(ProviderEntity provider) {

        if (provider == null) {

            logger.warn ("Country object for delete is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Deleting provider %s", provider));
            session.delete (provider);
            tx.commit ();
            logger.info (String.format ("Provider %s deleted!", provider));

        } catch (Exception e) {

            logger.error (String.format ("Error deleting provider %s", provider));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public ProviderEntity searchById(Integer id) {
        if (id == null) {

            logger.warn ("Consumer id is null!");
            return null;
        }

        Session session = null;
        ProviderEntity provider = new ProviderEntity();

        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            provider.setId(id);
            logger.info (String.format ("Searching provider %s", id));
            provider = (ProviderEntity) session.get(provider.getClass(),id);
            logger.info (String.format ("Consumer %s found!", id));

        } catch (Exception e) {

            logger.error (String.format ("Error searching provider %s", id));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return provider;
    }

    @Override
    public List<ProviderEntity> findAll() {

        Session session = null;
        List <ProviderEntity> providers = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.info (String.format ("Searching providers %s"));

            providers = (List<ProviderEntity>) session.createCriteria (ProviderEntity.class).list ();
            logger.info (String.format ("List providers found!"));

        } catch (Exception e) {

            logger.error (String.format ("Error searching list of providers"));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return providers;
    }

    @Override
    public void update(ProviderEntity provider) {

        if (provider == null) {

            logger.warn ("Consumer is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Updating provider %s ...",provider.getId()));
            session.update(provider);
            tx.commit ();
            logger.info (String.format ("Provider %s update!",provider.getId()));

        } catch (Exception e) {

            logger.error (String.format ("Error updating provider %s",provider.getId()));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
