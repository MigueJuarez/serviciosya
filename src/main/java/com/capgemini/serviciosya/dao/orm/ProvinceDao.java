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
    public void delete(ProvinceEntity province) {
        if (province == null) {

            logger.warn ("Country object for delete is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Deleting province %s", province));
            session.delete (province);
            tx.commit ();
            logger.info (String.format ("Province %s deleted!", province));

        } catch (Exception e) {

            logger.error (String.format ("Error deleting province %s", province));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }

    }

    @Override
    public ProvinceEntity searchById(Integer id) {

        if (id == null) {

            logger.warn ("Province id is null!");
            return null;
        }

        Session session = null;
        Transaction tx = null;
        ProvinceEntity province = new ProvinceEntity();

        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            province.setId(id);
            logger.info (String.format ("Searching province %s", id));
            province = (ProvinceEntity) session.get(province.getClass(),id);
            tx.commit ();
            logger.info (String.format ("Province %s found!", id));

        } catch (Exception e) {

            logger.error (String.format ("Error searching province %s", id));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return province;
    }

    @Override
    public List<ProvinceEntity> findAll() {

        Session session = null;
        List <ProvinceEntity> provinces = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.info (String.format ("Searching provinces %s"));

            provinces = (List<ProvinceEntity>) session.createCriteria (ProvinceEntity.class).list ();
            logger.info (String.format ("List provinces found!"));

        } catch (Exception e) {

            logger.error (String.format ("Error searching list of provinces"));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return provinces;
    }

    @Override
    public void update(ProvinceEntity target) {
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
