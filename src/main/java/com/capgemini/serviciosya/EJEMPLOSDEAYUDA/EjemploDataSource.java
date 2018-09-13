package com.capgemini.serviciosya.EJEMPLOSDEAYUDA;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploDataSource {

    public static void main(String[] args) throws Exception {

        // Create a BasicDataSource object and configure database

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");

        dataSource.setUrl("jdbc:postgresql://localhost:5432/serviciosya");

        dataSource.setUsername("postgres");

        dataSource.setPassword("12345678");

        //CONNECTION
        Connection conn = null;

        //STATEMENT
        PreparedStatement stmt = null;

        try {

        // Get connection and execute a simple query

            conn = dataSource.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM \"COUNTRY\"");

            ResultSet rs = stmt.executeQuery();

        // Print fetched data

            while (rs.next()) {

                System.out.println("Country : " + rs.getString("NAME_COUNTRY"));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (stmt != null) {

                stmt.close();

            }

            if (conn != null) {

                conn.close();

            }

        }
    }
}
