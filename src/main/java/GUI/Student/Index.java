package GUI.Student;

import Database.Database;
import Domain.Cursist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Index {
    private Database db = new Database();
    private TableView<Cursist> cursistTable = new TableView<>();
    private TableColumn<Cursist, String> emailCol = new TableColumn<>("Email");
    private TableColumn<Cursist, String> nameCol = new TableColumn<>("Naam");
    private TableColumn<Cursist, Date> geboCol = new TableColumn<>("GeboorteDatum");
    private TableColumn<Cursist, String> gesCol = new TableColumn<>("Geslacht");
    private TableColumn<Cursist, String> woonCol = new TableColumn<>("Woonplaats");
    private TableColumn<Cursist, String> adresCol = new TableColumn<>("Adres");
    private TableColumn<Cursist, String> landCol = new TableColumn<>("Land");
    private Label emailLabel = new Label("Email: ");
    private Label naamLabel = new Label("Naam: ");
    private Label geboorteDatumLabel = new Label("GeboorteDatum: ");
    private Label geslachtLabel = new Label("Geslacht: ");
    private Label woonplaatsLabel = new Label("woonplaats: ");
    private Label adresLabel = new Label("adres: ");
    private Label landLabel = new Label("land: ");
    private TextField tfEmail = new TextField();
    private TextField tfNaam = new TextField();
    private TextField tfGeboorteDatum = new TextField();
    private TextField tfGeslacht = new TextField();
    private TextField tfWoonplaats = new TextField();
    private TextField tfAdres = new TextField();
    private TextField tfLand = new TextField();
    private Button btnInsert = new Button("Toevoegen");
    private Button btnDelete = new Button("Verwijderen");
    private Button btnUpdate = new Button("Update");

    public ObservableList<Cursist> getCursist() {
        ObservableList<Cursist> cursistObservableList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Cursisten";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Cursist cursist = new Cursist(
                        rs.getString("email"),
                        rs.getString("naam"),
                        rs.getDate("geboorteDatum"),
                        rs.getString("geslacht"),
                        rs.getString("woonPlaats"),
                        rs.getString("adres"),
                        rs.getString("land"));
                cursistObservableList.add(cursist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursistObservableList;
    }

    public Parent readCursist() {
        ObservableList<Cursist> list = getCursist();
        BorderPane bp = new BorderPane();
        GridPane gridPane = new GridPane();
        HBox hbox = new HBox();

        getDataTable(list, bp);
        getButtonsLayout(hbox);
        getUserInputLayout(bp, gridPane, hbox);

        return bp;
    }

    private void getButtonsLayout(HBox hbox) {
        btnInsert.setOnAction((event) -> toevoegen());

        hbox.getChildren().setAll(btnInsert, btnUpdate, btnDelete);
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(20, 0, 0, 0));
    }



    private void getDataTable(ObservableList<Cursist> list, BorderPane bp) {
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("naam"));
        this.gesCol.setCellValueFactory(new PropertyValueFactory<>("geslacht"));
        this.geboCol.setCellValueFactory(new PropertyValueFactory<>("geboorteDatum"));
        this.woonCol.setCellValueFactory(new PropertyValueFactory<>("woonPlaats"));
        this.adresCol.setCellValueFactory(new PropertyValueFactory<>("adres"));
        this.landCol.setCellValueFactory(new PropertyValueFactory<>("land"));
        this.cursistTable.setItems(list);
        this.cursistTable.getColumns().addAll(this.emailCol, this.nameCol, this.geboCol, this.gesCol, this.woonCol, this.adresCol, this.landCol);
        bp.setRight(this.cursistTable);
        bp.setPadding(new Insets(25, 25, 25, 25));
    }

    private void getUserInputLayout(BorderPane bp, GridPane gridPane, HBox hbox) {
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        bp.setLeft(gridPane);

        gridPane.add(emailLabel, 0, 0);
        gridPane.add(tfEmail, 1, 0);
        gridPane.add(naamLabel, 0, 1);
        gridPane.add(tfNaam, 1, 1);
        gridPane.add(geboorteDatumLabel, 0, 2);
        gridPane.add(tfGeboorteDatum, 1, 2);
        gridPane.add(geslachtLabel, 0, 3);
        gridPane.add(tfGeslacht, 1, 3);
        gridPane.add(woonplaatsLabel, 0, 4);
        gridPane.add(tfWoonplaats, 1, 4);
        gridPane.add(adresLabel, 0, 5);
        gridPane.add(tfAdres, 1, 5);
        gridPane.add(landLabel, 0, 6);
        gridPane.add(tfLand, 1, 6);
        gridPane.add(hbox, 0, 7);
    }

    public void toevoegen() {
        String query = "INSERT INTO cursisten VALUES('" + this.tfEmail.getText() + "','"
                + this.tfNaam.getText() + "','" + this.tfGeboorteDatum.getText() + "','"
                + this.tfGeslacht.getText() + "','" + this.tfWoonplaats.getText() + "','"
                + this.tfAdres.getText() + "','" + this.tfLand.getText() + "')";
        this.VoerQueryUit(query);
        this.readCursist();
    }

    public void VoerQueryUit(String query) {
        Connection conn = db.getConnection();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Scene getVıew() {
        Parent layout = this.readCursist();
        Scene scene = new Scene(layout);
        return scene;
    }
}