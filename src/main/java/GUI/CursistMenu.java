package GUI;

import Database.Database;
import Domain.Course;
import Domain.Cursist;
import Database.CursistController;


import Domain.Geslacht;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
    private TableColumn<Cursist, Integer> bdCol = new TableColumn<>("Geboortedag");
    private TableColumn<Cursist, Integer> bmCol = new TableColumn<>("Geboortemaand");
    private TableColumn<Cursist, Integer> byCol = new TableColumn<>("Geboortejaar");
    private TableColumn<Cursist, String> sexCol = new TableColumn<>("Geslacht");
    private TableColumn<Cursist, String> cityCol = new TableColumn<>("Woonplaats");
    private TableColumn<Cursist, String> pcCol = new TableColumn<>("Postcode");
    private TableColumn<Cursist, String> streetCol = new TableColumn<>("Straatnaam");
    private TableColumn<Cursist, Integer> houseNrCol = new TableColumn<>("Huisnummer");
    private TableColumn<Cursist, String> countryCol = new TableColumn<>("Land");
    private Label emailLabel = new Label("Email: ");
    private Label nameLabel = new Label("Naam: ");
    private Label birthDateLabel = new Label("GeboorteDatum d/m/j: ");
    private Label sexLabel = new Label("Geslacht: ");
    private Label cityLabel = new Label("woonplaats: ");
    private Label pcLabel = new Label("Postcode: ");
    private Label streetLabel = new Label("Straatnaam: ");
    private Label houseNrLabel = new Label("Huisnummer: ");
    private Label countryLabel = new Label("Land: ");
    private TextField tfEmail = new TextField();
    private TextField tfName = new TextField();
    private TextField tfBirthDay = new TextField();
    private TextField tfBirthMonth = new TextField();
    private TextField tfBirthYear = new TextField();
    private ComboBox sexMenuBox = new ComboBox();
    private TextField tfCity = new TextField();
    private TextField tfPostalCode = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfhouseNr = new TextField();
    private TextField tfCountry = new TextField();
    private Button btnInsert = new Button("Toevoegen");
    private Button btnDelete = new Button("Verwijderen");
    private Button btnUpdate = new Button("Update");
    public Button backBtn = new Button("Terug");



    // onderstaande methode zet cursisten data in de cellen van de tabel.
    public void showCursists(){
        ObservableList<Cursist> cursistenList = cController.getCursistList();
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
        this.bdCol.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        this.bmCol.setCellValueFactory(new PropertyValueFactory<>("birthMonth"));
        this.byCol.setCellValueFactory(new PropertyValueFactory<>("birthYear"));
        this.cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        this.pcCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        this.streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
        this.houseNrCol.setCellValueFactory(new PropertyValueFactory<>("houseNr"));
        this.countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        this.cursistTable.setItems(cursistenList);
    }

    // methode maakt GUI voor cursisten
    public Scene getView() {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        HBox hboxBtns = new HBox ();
        hboxBtns.getChildren().setAll(this.backBtn, this.btnInsert, this.btnUpdate, this.btnDelete);
        hboxBtns.setSpacing(25);
        hboxBtns.setPadding(new Insets(20, 0, 0 , 0));

        HBox hboxBDate = new HBox ();
        hboxBDate.getChildren().setAll(this.tfBirthDay, this.tfBirthMonth, this.tfBirthYear);
        
        this.btnInsert.setOnAction((event)->this.insertRecord());
        this.btnDelete.setOnAction((event)->this.deleteRecord());
        this.btnUpdate.setOnAction((event)->this.updateRecord());
        this.setCellValueFromTableToTextField();
        this.cursistTable.getColumns().addAll(this.emailCol, this.nameCol, this.bdCol, this.bmCol, this.byCol,
                this.sexCol, this.cityCol, this.pcCol, this.streetCol, this.houseNrCol, this.countryCol);

        bp.setRight(this.cursistTable);
        bp.setLeft(gridPane);
        this.showCursists();

        for (Geslacht geslacht : Geslacht.values()) {
            sexMenuBox.getItems().add(geslacht);
        }

        gridPane.add(emailLabel, 0, 0);
        gridPane.add(tfEmail, 1 ,0);
        gridPane.add(nameLabel, 0,1);
        gridPane.add(tfName, 1, 1);
        gridPane.add(birthDateLabel, 0,2);
        gridPane.add(hboxBDate, 1, 2);
        gridPane.add(sexLabel, 0, 3);
        gridPane.add(sexMenuBox, 1, 3);
        gridPane.add(cityLabel, 0, 4);
        gridPane.add(tfCity, 1, 4);
        gridPane.add(pcLabel, 0, 5);
        gridPane.add(tfPostalCode, 1, 5);
        gridPane.add(streetLabel, 0, 6);
        gridPane.add(tfStreet, 1, 6);
        gridPane.add(houseNrLabel, 0, 7);
        gridPane.add(tfhouseNr, 1, 7);
        gridPane.add(countryLabel, 0, 8);
        gridPane.add(tfCountry, 1, 8);
        gridPane.add(hboxBtns, 0, 9);

        Scene scene = new Scene(bp);
        return scene;
    }



    //De methoden die toevoegButton moet uitvoeren
    private void insertRecord(){
        String query = cController.makeInsertQuery(
                this.tfEmail.getText(),
                this.tfName.getText(),
                Integer.parseInt(this.tfBirthDay.getText()),
                Integer.parseInt(this.tfBirthMonth.getText()),
                Integer.parseInt(this.tfBirthYear.getText()),
                this.sexMenuBox.getValue().toString(),
                this.tfCity.getText(),
                this.tfPostalCode.getText(),
                this.tfStreet.getText(),
                Integer.parseInt(this.tfhouseNr.getText()),
                this.tfCountry.getText());
        cController.executeQuery(query);
        this.showCursists();
    }

    private void deleteRecord(){
        //Controleer of er een record geselecteerd is.
        if (cursistTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();}

        // Ophalen en vervolgens verwijderen van record a.d.h.v muisselectie
        else {
            TablePosition pos = cursistTable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Cursist cursist = cursistTable.getItems().get(row);

            String query = cController.makeDeleteQuery(cursist.getEmail());
            this.cController.executeQuery(query);
            this.showCursists();
        }
    }

    public void updateRecord() {
        if (cursistTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();}
        else {
            String query = cController.makeUpdateQuery(
                    this.tfEmail.getText(),
                    this.tfName.getText(),
                    Integer.parseInt(this.tfBirthDay.getText()),
                    Integer.parseInt(this.tfBirthMonth.getText()),
                    Integer.parseInt(this.tfBirthYear.getText()),
                    this.sexMenuBox.getValue().toString(),
                    this.tfCity.getText(),
                    this.tfPostalCode.getText(),
                    this.tfStreet.getText(),
                    Integer.parseInt(this.tfhouseNr.getText()),
                    this.tfCountry.getText());
            cController.executeQuery(query);
            this.showCursists();
        }
    }

    //Zet data in de inputfields door op een cel van de tabel te klikken.
    public void setCellValueFromTableToTextField(){
        cursistTable.setOnMouseClicked(e -> {
            Cursist cursist = cursistTable.getItems().get(cursistTable.getSelectionModel().getSelectedIndex());
            this.tfEmail.setText(cursist.getEmail());
            this.tfName.setText(cursist.getName());
            this.tfBirthDay.setText(String.valueOf(cursist.getBirthDay()));
            this.tfBirthMonth.setText(String.valueOf(cursist.getBirthMonth()));
            this.tfBirthYear.setText(String.valueOf(cursist.getBirthYear()));
            this.sexMenuBox.setValue(cursist.getSex());
            this.tfCity.setText(cursist.getCity());
            this.tfPostalCode.setText(cursist.getPostalCode());
            this.tfStreet.setText(cursist.getStreet());
            this.tfhouseNr.setText(String.valueOf(cursist.getHouseNr()));
            this.tfCountry.setText(cursist.getCountry());
        });
    }
}

