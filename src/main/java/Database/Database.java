package Database;

//import javafx.collections.ObservableList;

import java.sql.*;

import Domain.Cursist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

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
