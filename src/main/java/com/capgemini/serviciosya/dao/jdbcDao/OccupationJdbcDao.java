package com.capgemini.serviciosya.dao.jdbcDao;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.daoException.DaoException;
import com.capgemini.serviciosya.dao.interfaceDao.ITablesDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

public class OccupationJdbcDao implements ITablesDao<Occupation,String> {

    private static final Logger logger = (Logger) Logger.getLogger (String.valueOf(OccupationJdbcDao.class));

    public OccupationJdbcDao() {

        super ();
    }


    @Override
    public void create(Occupation object) {

    }

    @Override
    public List<Occupation> findAllOccupations() {
// Occupations list.
        List<Occupation> occupations = new ArrayList<>();

        try {

            // Get connection.
            logger.info ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();


            // Execute the query.
            String sql = "select * from occupation";
            logger.info (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);


            // Read the result.

            while (rs.next ()) {

                Occupation o = new Occupation ();
                o.setId (rs.getInt ("ID"));
                o.setName (rs.getString ("NAME"));
                o.setDescription (rs.getString ("DESCRIPTION"));

                // Add new object to list.
                occupations.add (o);
            }

        } catch (Exception e) {

            // Failure.
            //logger.error ("Failure searching all occupations");
            throw new DaoException("Failure searching all occupations", e);
        }

        // Return results.
        return occupations;
    }

    @Override
    public void add(Occupation occupation) {

        try {

            // Get connection.
            logger.info ("Getting new connection...");

            Connection conn = CapgeminiDB.getConnection ();

            String sql = "insert into occupation (name, description) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setString (1, occupation.getName ());
            ps.setString (2, occupation.getDescription ());


            // Execute the query.
            logger.info (String.format ("Executing query [%s]", sql));
            int c = ps.executeUpdate ();


            // Read the result.
            if (c == 0) {

                throw new DaoException ("Failure inserting new occupations C=0 ");
            }


        } catch (SQLException e) {

            // Failure.
            logger.info ("Failure inserting new occupation!");
            throw new DaoException ("Failure inserting new occupation!" + e.getMessage(), e);

        } catch (Exception e) {

            // Failure.
            logger.info("Failure inserting new occupation!");
            throw new DaoException (e.getMessage (), e);
        }
    }


    @Override
    public void delete(Occupation occupation) {
        /*
        try {
            stm = this.cnn.prepareStatement ("DELETE FROM \"OCCUPATION\" WHERE ID =" + occupation.getId());
            int r ;
            //r= (int) stm.executeUpdate ();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    public Occupation searchById(String id) {
        return null;
    }

    @Override
    public void update(String id, Occupation occupation) {

    }
}
