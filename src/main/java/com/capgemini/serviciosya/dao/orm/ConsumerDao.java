package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import com.capgemini.serviciosya.dao.IConsumerDao;
import com.capgemini.serviciosya.dao.daoException.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ConsumerDao implements IConsumerDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();
    private static final Logger logger= Logger.getLogger (String.valueOf(ConsumerDao.class));

    @Override
    public void create(ConsumerEntity consumer) {
        // Validate the arguments.
        if (consumer == null) {

            logger.warn ("Consumer object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Creating new consumer %s", consumer));
            session.save (consumer);
            tx.commit ();
            logger.info (String.format ("New consumer %s created!", consumer));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new consumer %s", consumer));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete(ConsumerEntity consumer) {

        if (consumer == null) {

            logger.warn ("Country object for delete is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Deleting consumer %s", consumer));
            session.delete (consumer);
            tx.commit ();
            logger.info (String.format ("Consumer %s deleted!", consumer));

        } catch (Exception e) {

            logger.error (String.format ("Error deleting consumer %s", consumer));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public ConsumerEntity searchById(Integer id) {

        if (id == null) {

            logger.warn ("Consumer id is null!");
            return null;
        }

        Session session = null;
        ConsumerEntity consumer = new ConsumerEntity();

        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            consumer.setId(id);
            logger.info (String.format ("Searching consumer %s", id));
            consumer = (ConsumerEntity) session.get(consumer.getClass(),id);
            logger.info (String.format ("Consumer %s found!", id));

        } catch (Exception e) {

            logger.error (String.format ("Error searching consumer %s", id));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return consumer;
    }

    @Override
    public List<ConsumerEntity> findAll() {

        Session session = null;
        List <ConsumerEntity> consumers = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.info (String.format ("Searching consumers %s"));

            consumers = (List<ConsumerEntity>) session.createCriteria (ConsumerEntity.class).list ();
            logger.info (String.format ("List consumers found!"));

        } catch (Exception e) {

            logger.error (String.format ("Error searching list of consumers"));
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
        return consumers;
    }

    @Override
    public void update(ConsumerEntity consumer) {

        if (consumer == null) {

            logger.warn ("Consumer is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.info ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.info (String.format ("Updating consumer %s ...",consumer.getId()));
            session.update(consumer);
            tx.commit ();
            logger.info (String.format ("Consumer %s update!",consumer.getId()));

        } catch (Exception e) {

            logger.error (String.format ("Error updating consumer %s",consumer.getId()));
            tx.rollback ();
            throw new DaoException(e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
