package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.domain.Occupation;

import java.sql.*;
import java.util.List;

import java.lang.Integer.*;
import java.util.logging.Logger;

import static java.lang.Integer.*;

public class OccupationJdbcDao implements IOccupationDao {

    private String url = "jdbc:postgresql://localhost:5432/serviciosya";
    private Connection cnn;
    private Statement stm;
    private static final Logger logger = (Logger) Logger.getLogger (String.valueOf(OccupationJdbcDao.class));


    public void conection() throws SQLException {
        cnn = DriverManager.getConnection(url,"postgres","12345678");
        stm = this.cnn.createStatement ();
    }

    @Override
    public List<Occupation> findAllOccupations() {

        try {
            ResultSet resultSet = stm.executeQuery ("SELECT * from \"OCCUPATION\"");
            return (List<Occupation>) resultSet.getArray("NAME");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(Occupation occupation) {

        try {

            PreparedStatement pstm = this.cnn.prepareStatement("INSERT INTO \"OCCUPATION\" (name) VALUES (?)");
            pstm.setString(1,occupation.getDescription());
            int r = pstm.executeUpdate ();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Occupation occupation) {
        try {
            stm = this.cnn.prepareStatement ("DELETE FROM \"OCCUPATION\" WHERE ID =" + occupation.getId());
            int r ;
            //r= (int) stm.executeUpdate ();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Occupation searchById(String id) {
        return null;
    }
}
