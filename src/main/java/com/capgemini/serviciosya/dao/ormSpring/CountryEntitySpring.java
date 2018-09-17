package com.capgemini.serviciosya.dao.ormSpring;

import com.capgemini.serviciosya.dao.ICountryDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.security.sasl.SaslServer;

public class CountryEntitySpring {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(CountryEntitySpring country){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(country);


    }
}
