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

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost/testdb");

        dataSource.setUsername("root");

        dataSource.setPassword("root");


        Connection conn = null;

        PreparedStatement stmt = null;

        try {

// Get connection and execute a simple query

            conn = dataSource.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM users");

            ResultSet rs = stmt.executeQuery();

// Print fetched data

            while (rs.next()) {

                System.out.println("Username : " + rs.getString("username"));

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
