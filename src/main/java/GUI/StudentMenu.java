package GUI;

import Database.Database;
import Domain.Student;
import Database.StudentController;


import Domain.Geslacht;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.util.Date;

public class StudentMenu {
    private Database db = new Database();
    private StudentController sController = new StudentController();
    private TableView<Student> studentTable = new TableView<>();
    private TableColumn<Student, String> emailCol = new TableColumn<>("Email");
    private TableColumn<Student, String> nameCol = new TableColumn<>("Naam");
    private TableColumn<Student, LocalDate> bdCol = new TableColumn<>("Geboortedatum");
    private TableColumn<Student, String> sexCol = new TableColumn<>("Geslacht");
    private TableColumn<Student, String> cityCol = new TableColumn<>("Woonplaats");
    private TableColumn<Student, String> pcCol = new TableColumn<>("Postcode");
    private TableColumn<Student, String> streetCol = new TableColumn<>("Straatnaam");
    private TableColumn<Student, Integer> houseNrCol = new TableColumn<>("Huisnummer");
    private TableColumn<Student, String> countryCol = new TableColumn<>("Land");
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
        ObservableList<Student> studentList = sController.getStudentList();
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
        this.bdCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        this.cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        this.pcCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        this.streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
        this.houseNrCol.setCellValueFactory(new PropertyValueFactory<>("houseNr"));
        this.countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        this.studentTable.setItems(studentList);
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
        this.studentTable.getColumns().clear();
        this.studentTable.getColumns().addAll(this.emailCol, this.nameCol, this.bdCol,
                this.sexCol, this.cityCol, this.pcCol, this.streetCol, this.houseNrCol, this.countryCol);

        bp.setRight(this.studentTable);
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
        String query = sController.makeInsertQuery(
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
        db.executeQuery(query);
        this.showCursists();
    }

    private void deleteRecord(){
        //Controleer of er een record geselecteerd is.
        if (studentTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();}

        // Ophalen en vervolgens verwijderen van record a.d.h.v muisselectie
        else {
            TablePosition pos = studentTable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Student student = studentTable.getItems().get(row);

            String query = sController.makeDeleteQuery(student.getEmail());
            this.db.executeQuery(query);
            this.showCursists();
        }
    }

    public void updateRecord() {
        if (studentTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();}
        else {
            String query = sController.makeUpdateQuery(
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
            db.executeQuery(query);
            this.showCursists();
        }
    }

    //Zet data in de inputfields door op een cel van de tabel te klikken.
    public void setCellValueFromTableToTextField(){
        studentTable.setOnMouseClicked(e -> {
            Student student = studentTable.getItems().get(studentTable.getSelectionModel().getSelectedIndex());
            this.tfEmail.setText(student.getEmail());
            this.tfName.setText(student.getName());
            this.tfBirthDay.setText(String.valueOf(student.getBirthDay()));
            this.tfBirthMonth.setText(String.valueOf(student.getBirthMonth()));
            this.tfBirthYear.setText(String.valueOf(student.getBirthYear()));
            this.sexMenuBox.setValue(student.getSex());
            this.tfCity.setText(student.getCity());
            this.tfPostalCode.setText(student.getPostalCode());
            this.tfStreet.setText(student.getStreet());
            this.tfhouseNr.setText(String.valueOf(student.getHouseNr()));
            this.tfCountry.setText(student.getCountry());
        });
    }
}

