package GUI;

import Database.CourseController;
import Database.Database;
import Database.StudentController;
import Database.EnrollController;
import Domain.Course;
import Domain.Enroll;
import Domain.Student;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.sql.SQLException;
import java.time.LocalDate;


public class InschrijfMenu {
        public Button backBtn = new Button("Terug");
        private final Button enrollBtn = new Button("Inschrijven");
        private final Label introText = new Label("Schrijf je in!");

        private final Label mailText = new Label("* email: ");
        private final TextField mailTextField = new TextField();
        private final Label errorMail = new Label("");

        private Label courseName = new Label("* cursus: ");
        private ComboBox comboBoxCourse = new ComboBox();
        private ComboBox comboBoxMail = new ComboBox();
        private final Label errorCourse = new Label("");

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        EnrollController enrollController = new EnrollController();
        Database database = new Database();


        private Button btnInsert = new Button("Toevoegen");
        private Button btnDelete = new Button("Verwijderen");
        private Button btnUpdate = new Button("Update");

        private TableView<Enroll> enrollTable = new TableView<>();
        private TableColumn<Enroll, String> emailCol = new TableColumn<>("Email");
        private TableColumn<Enroll, String> dateCol = new TableColumn<>("Date");
        private TableColumn<Enroll, LocalDate> courseCol = new TableColumn<>("Course");
        private TableColumn<Enroll, String> certIDCol = new TableColumn<>("CertificateID");

        String emailCellValue = "";
        String courseCellValue = "";

    public Scene getScene() {
        BorderPane mainPane = new BorderPane();
        GridPane userInputPane = getContent();
        GridPane buttonsPane = getButtons();
        GridPane tablePane = getTable();




        mainPane.setCenter(userInputPane);
        mainPane.setBottom(buttonsPane);
        mainPane.setRight(tablePane);
        Scene scene = new Scene(mainPane,1000,400);
        return scene;
    }



    private GridPane getButtons() {
        GridPane pane = new GridPane();

        pane.add(backBtn,0,0);
        pane.add(btnInsert,1,0);
        btnInsert.setOnAction(actionEvent -> insertRecord());
        pane.add(btnUpdate,2,0);
        btnUpdate.setOnAction(actionEvent -> updateRecord());
        pane.add(btnDelete,3,0);
        btnDelete.setOnAction(actionEvent -> deleteRecord());
        this.setCellValueFromTableToTextField();

        pane.setPadding(new Insets(50,50,50,50));
        pane.setVgap(30);
        pane.setHgap(30);
        return pane;
    }

    private void deleteRecord(){
        //Controleer of er een record geselecteerd is.
        if (enrollTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();}

        // Ophalen en vervolgens verwijderen van record a.d.h.v muisselectie
        else {
            TablePosition pos = enrollTable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Enroll enroll = enrollTable.getItems().get(row);

            String query = enrollController.makeDeleteQuery(enroll.getEmail(),enroll.getCourseNameFK(),enroll.getRegistrationDate());
            this.database.executeQuery(query);
            this.showEnrolls();
        }
    }

    public void updateRecord() {

            if (enrollTable.getSelectionModel().getSelectedItem() == null) {
                Alert warningAlert = new Alert(Alert.AlertType.WARNING);
                warningAlert.setContentText("Geen record geselecteerd");
                warningAlert.show();}
            else {
                String query = enrollController.makeUpdateQuery(
                        comboBoxMail.getValue().toString(),
                        comboBoxCourse.getValue().toString(),
                        this.emailCellValue,
                        this.courseCellValue);
                database.executeQuery(query);
                this.showEnrolls();
            }
//            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
//            warningAlert.setContentText("Er bestaat al een record met deze waardes!");
//            warningAlert.show();

    }
    //Zet data in de inputfields door op een cel van de tabel te klikken.
    public void setCellValueFromTableToTextField(){
        enrollTable.setOnMouseClicked(e -> {
            Enroll enroll = enrollTable.getItems().get(enrollTable.getSelectionModel().getSelectedIndex());
            this.comboBoxMail.setValue(enroll.getEmail());
            this.comboBoxCourse.setValue(enroll.getCourseNameFK());
            this.emailCellValue = enroll.getEmail();
            this.courseCellValue = enroll.getCourseNameFK();
        });
    }

    private GridPane getContent() {
        GridPane gridPane = new GridPane();
        gridPane.add(introText,0,0);
        introText.setFont(Font.font("Verdana",15));

        gridPane.add(mailText,0,1);
        gridPane.add(comboBoxMail,1,1);
        comboBoxMail.setPrefWidth(150);
        comboBoxMail.getItems().clear();
        for (Student student : studentController.getStudentList()) {
            comboBoxMail.getItems().add(student.getEmail());
        }
        gridPane.add(errorMail,2,1);
        gridPane.add(courseName,0,2);
        gridPane.add(comboBoxCourse,1,2);
        gridPane.add(errorCourse,2,2);
        comboBoxCourse.setPrefWidth(150);
        comboBoxCourse.getItems().clear();
        for (Course courses : courseController.getCourse()) {
            comboBoxCourse.getItems().add(courses.getCourse());
        }

        gridPane.setPadding(new Insets(50,50,50,50));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        return gridPane;
    }

    //De methoden die toevoegButton moet uitvoeren
    private void insertRecord(){

        LocalDate date = LocalDate.now();
        String query = enrollController.makeInsertQuery(
                comboBoxMail.getValue().toString(),
                 1,
                date,
                comboBoxCourse.getValue().toString()
                );

        database.executeQuery(query);
        this.showEnrolls();
    }

    private GridPane getTable() {
        GridPane pane = new GridPane();
        this.enrollTable.getColumns().clear();
        this.enrollTable.getColumns().addAll(this.emailCol, this.dateCol, this.courseCol, this.certIDCol);
        pane.add(enrollTable,0,0);
        this.showEnrolls();
        return pane;
    }

    public void showEnrolls(){
        ObservableList<Enroll> enrollObservableList = enrollController.getEnrollmentList();
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.certIDCol.setCellValueFactory(new PropertyValueFactory<>("certificateFK"));
        this.dateCol.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        this.courseCol.setCellValueFactory(new PropertyValueFactory<>("courseNameFK"));
        this.enrollTable.setItems(enrollObservableList);
    }

    public void showDuplicationError () {
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);
        warningAlert.setContentText("Er bestaat al een record met deze combinatie!");
        warningAlert.show();
    }
}
