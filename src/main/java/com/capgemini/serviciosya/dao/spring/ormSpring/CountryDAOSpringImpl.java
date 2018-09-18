package com.capgemini.serviciosya.dao.spring.ormSpring;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.dao.spring.CountryDAOSpring;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAOSpringImpl implements CountryDAOSpring {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CountryEntity country) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(country);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(CountryEntity country) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(country);
        tx.commit();
        session.close();
    }

    @Override
    public List<CountryEntity> findAll() {
        List<CountryEntity> countries;
        Session session = this.sessionFactory.openSession();
        countries = session.createCriteria("SELECT * FROM country").list();
        return  countries;
    }

    @Override
    public CountryEntity searchById(Integer id) {
        CountryEntity country = null;
        Session session = this.sessionFactory.openSession();
        country = (CountryEntity) session.get(country.getClass(),id);
        return country;
    }
}
