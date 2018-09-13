package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.IProvinceDao;
import com.capgemini.serviciosya.dao.daoException.DaoException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.apache.log4j.Logger;

import java.util.List;

public class ProvinceDao implements IProvinceDao{

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();

    private static final Logger logger= Logger.getLogger (ProvinceDao.class);

    @Override
    public void create(ProvinceEntity target) {

        if(target == null)
        {
            logger.warn("Warning object null.");
            return;
        }

        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(target);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw new DaoException (e.getMessage (), e);
        }finally {
            session.close();
        }
    }

    @Override
    public List<ProvinceEntity> findAllOccupations() {

        return null;
    }

    @Override
    public void add(ProvinceEntity object) {

    }

    @Override
    public void delete(ProvinceEntity object) {

    }

    @Override
    public ProvinceEntity searchById(Integer id) {
        return null;
    }

    @Override
    public void update(Integer id, ProvinceEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Province object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating Province %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Province %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating Province %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
