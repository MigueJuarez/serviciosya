package com.capgemini.test.serviciosya.service.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.logging.Logger;

public class JDBCTest {

    private Connection cnn;

    // Logger object.
    private static final Logger logger = (Logger) Logger.getLogger (String.valueOf(JDBCTest.class));

    public JDBCTest () {

        super ();
    }

    private void writeResult (ResultSet resultSet) throws SQLException {

        // ResultSet is initially before the first data set
        while (resultSet.next ()) {

            int id = resultSet.getInt ("ID_COUNTRY");
            String name   = resultSet.getString ("NAME_COUNTRY");

            //logger.debug (String.format ("Id: %s", id));
            logger.info (String.format ("Name: %s", name));
        }
    }


    @Before
    public void setup () throws Exception {

        // Register the driver.
        Class.forName ("org.postgresql.Driver");

        // Create a new connection.
        this.cnn = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/serviciosya", "postgres", "12345678");
    }

    @Test
    public void testAdd () {

        try {

            PreparedStatement pstm = this.cnn.prepareStatement ("INSERT INTO \"COUNTRY\" (name) VALUES (?)");

            pstm.setString (1, "Peru");

            // Execute the insert.
            int r = pstm.executeUpdate ();

            Assert.assertTrue ("Failure executing Insert !!!", r > 0);

        } catch (Exception e) {

            e.printStackTrace ();
            //Assert.assertTrue ("Failure executing Insert...", e == null);
        }
    }

    @Test
    public void testRead () {

        try {

            Statement stm = this.cnn.createStatement ();

            // Result set get the result of the SQL query
            ResultSet resultSet = stm.executeQuery ("SELECT * from \"COUNTRY\"");

            // Print the messages.
            writeResult (resultSet);

            Assert.assertTrue("The tables is empty !!!", !resultSet.isBeforeFirst ());

        } catch (Exception e) {

            e.printStackTrace ();
            //Assert.assertTrue ("Failure executing SELECT Into...", e == null);
        }
    }



    @Test
    public void testUpdate () {

        try {

            Statement stm = this.cnn.createStatement ();

            int r = stm.executeUpdate ("UPDATE \"COUNTRY\" SET \"NAME\" = UPPER(\"NAME\")");

            Assert.assertTrue ("Failure executing Update !!!", r > 0);

        } catch (Exception e) {

            e.printStackTrace ();
            Assert.assertTrue ("Failure executing Update...", e == null);
        }
    }

    @Test
    public void testDelete () {

        try {

            PreparedStatement stm = this.cnn.prepareStatement ("DELETE FROM \"COUNTRY\"");
            int r = stm.executeUpdate ();

            Assert.assertTrue("Failure executing Delete !!!", r > 0);

        } catch (Exception e) {

            e.printStackTrace ();
            Assert.assertTrue ("Failure executing Delete...", e == null);
        }
    }

    @Test
    public void testTX () {

        try {

            this.cnn.setAutoCommit (false);

            this.cnn.createStatement ().
                    executeUpdate ("INSERT INTO \"COUNTRY\" (\"NAME\") VALUES ('BRASIL')");

            this.cnn.createStatement ().
                    executeUpdate ("INSERT INTO \"COUNTRY\" (\"NAME\") VALUES ('PERU')");

            this.cnn.createStatement ().
                    executeUpdate ("DELETE FROM \"COUNTRY\"");

            int a = 1/0;

            this.cnn.commit ();

        } catch (Exception e) {

            try {
                this.cnn.rollback ();
            } catch (Exception e2) {}

            e.printStackTrace ();
            Assert.assertTrue ("Failure executing Insert...", e == null);
        }
    }

    @After
    public void destroy () throws Exception {

        this.cnn.close ();
    }
}
