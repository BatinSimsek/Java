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

    //Deze methoden voert een query uit.
    public void executeQueryThrowsException (String query) throws SQLException {
        Connection conn = this.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }

    public void executeQuery (String query){
        try {
            executeQueryThrowsException(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
