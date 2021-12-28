package GUI;

import Database.Database;
import Domain.Cursist;
import Database.CursistController;


import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


import java.sql.*;

public class CursistMenu {
    private Database db = new Database();
    private CursistController cController = new CursistController();
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



    // onderstaande methode zet cursisten data in de cellen van de tabel.
    public void toonCursisten(){
        ObservableList<Cursist> cursistenLijst = cController.getCursistLijst();
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("naam"));
        this.gesCol.setCellValueFactory(new PropertyValueFactory<>("geslacht"));
        this.geboCol.setCellValueFactory(new PropertyValueFactory<>("geboorteDatum"));
        this.woonCol.setCellValueFactory(new PropertyValueFactory<>("woonPlaats"));
        this.adresCol.setCellValueFactory(new PropertyValueFactory<>("adres"));
        this.landCol.setCellValueFactory(new PropertyValueFactory<>("land"));
        this.cursistTable.setItems(cursistenLijst);
    }

    // methode maakt GUI voor cursisten
    public Scene maakGUI() {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        HBox hbox = new HBox ();
        hbox.getChildren().setAll(this.btnInsert, this.btnUpdate, this.btnDelete);
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(20, 0, 0 , 0));

        this.btnInsert.setOnAction((event)->this.recordToevoegen());

        this.cursistTable.getColumns().addAll(this.emailCol, this.nameCol, this.geboCol, this.gesCol, this.woonCol, this.adresCol, this.landCol);

        bp.setRight(this.cursistTable);
        bp.setLeft(gridPane);
        this.toonCursisten();

        gridPane.add(emailLabel, 0, 0);
        gridPane.add(tfEmail, 1 ,0);
        gridPane.add(naamLabel, 0,1);
        gridPane.add(tfNaam, 1, 1);
        gridPane.add(geboorteDatumLabel, 0,2);
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

        Scene scene = new Scene(bp);
        return scene;
    }



    //De methoden die toevoegButton moet uitvoeren
    private void recordToevoegen(){
        String query = cController.toevoegQuery(
                this.tfEmail.getText(),
                this.tfNaam.getText(),
                this.tfGeboorteDatum.getText(),
                this.tfGeslacht.getText(),
                this.tfWoonplaats.getText(),
                this.tfAdres.getText(),
                this.tfWoonplaats.getText());
        cController.VoerQueryUit(query);
        this.toonCursisten();
    }

//    public Scene getVıew() {
//        Parent layout = this.maakGUI();
//
//        Scene scene = new Scene(layout);
//
//        return scene;
//    }
}

