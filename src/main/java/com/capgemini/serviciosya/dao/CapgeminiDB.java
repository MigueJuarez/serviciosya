package com.capgemini.serviciosya.dao;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CapgeminiDB {

    private static final BasicDataSource dataSource = new BasicDataSource ();

    static {

        try {

            Properties pop = new Properties();
            pop.load(CapgeminiDB.class.getClassLoader().
                    getResourceAsStream ("jdbc.properties"));

            dataSource.setUrl(pop.getProperty ("jdbc.url"));
            dataSource.setUsername (pop.getProperty ("jdbc.user"));
            dataSource.setPassword (pop.getProperty ("jdbc.pw"));
            dataSource.setMinIdle (5);
            dataSource.setMaxIdle (10);

        } catch (Exception e) {

            throw new DaoException(e);
        }

    }

    public static final Connection getConnection () throws SQLException {

        return dataSource.getConnection();
    }
}
