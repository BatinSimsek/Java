package Database;

//import javafx.collections.ObservableList;

import java.sql.*;

public class Database {

    public Connection getConnection() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;");
            return connect;

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }




}
