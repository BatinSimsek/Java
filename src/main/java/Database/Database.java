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
    private TableView<Cursist> cursistTable = new TableView<>();
    private TableColumn<Cursist, String> emailCol = new TableColumn<>("Email");
    private TableColumn<Cursist, String> nameCol = new TableColumn<>("Naam");
    private TableColumn<Cursist, Date> geboCol = new TableColumn<>("GeboorteDatum");
    private TableColumn<Cursist, String> gesCol = new TableColumn<>("Geslacht") ;
    private TableColumn<Cursist, String> woonCol = new TableColumn<>("Woonplaats");
    private TableColumn<Cursist, String> adresCol = new TableColumn<>("Adres") ;
    private TableColumn<Cursist, String> landCol = new TableColumn<>("Land");



    public Connection getConnection() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;");
            return connect;

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }


    public ObservableList<Cursist> getCursist() {
        ObservableList<Cursist> cursistObservableList = FXCollections.observableArrayList();
        //test
        String query = "SELECT * FROM Cursisten";
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            con = getConnection();
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("naam");
                Date geboortedatum = rs.getDate("geboorteDatum");
                String geslacht = rs.getString("geslacht");
                String woonplaats = rs.getString("woonPlaats");
                String adres = rs.getString("adres");
                String land = rs.getString("land");
                Cursist cursist = new Cursist(email, name, geboortedatum, geslacht, woonplaats, adres, land);
                cursistObservableList.add(cursist);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        //catch (ClassNotFoundException e) {
        //    return null;
        // }
        return cursistObservableList;
    }
    public void showCursists(){
        ObservableList<Cursist> list = getCursist();
        emailCol.setCellValueFactory(new PropertyValueFactory<Cursist, String>("email"));
        cursistTable.setItems(list);

    }

    public Parent getViewCursist(){
        ObservableList<Cursist> list = getCursist();
        BorderPane bp = new BorderPane();;
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("naam"));
        this.gesCol.setCellValueFactory(new PropertyValueFactory<>("geslacht"));
        this.geboCol.setCellValueFactory(new PropertyValueFactory<>("geboorteDatum"));
        this.woonCol.setCellValueFactory(new PropertyValueFactory<>("woonPlaats"));
        this.adresCol.setCellValueFactory(new PropertyValueFactory<>("adres"));
        this.landCol.setCellValueFactory(new PropertyValueFactory<>("land"));
        this.cursistTable.setItems(list);
        this.cursistTable.getColumns().addAll(this.emailCol, this.nameCol, this.geboCol, this.gesCol, this.woonCol,this.adresCol, this.landCol);
        bp.setCenter(this.cursistTable);

        return bp;
    }

}
