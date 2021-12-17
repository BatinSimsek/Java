package database;

import java.sql.*;

public class database {

    public Connection getConnection(){
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=cursus;integratedSecurity=true;");
            return connect;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }

}
