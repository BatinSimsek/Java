package GUI;

import Database.CourseController;
import Database.ContentItemController;
import Database.Database;
import Domain.ContentItems;
import Domain.Course;
import Domain.Level;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CourseMenu {
    private Database db = new Database();
    private CourseController coursesController = new CourseController();
    private ContentItemController contentItemController = new ContentItemController();
    private TableView<Course> courseTable = new TableView<>();
    private TableColumn<Course, String> cursusNameTable = new TableColumn<>("Cursusnaam");
    private TableColumn<Course, String> subjectTable = new TableColumn<>("Onderwerp");
    private TableColumn<Course, String> descriptionTable = new TableColumn<>("Introductietekst");
    private TableColumn<Course, String> levelTable = new TableColumn<>("Niveau");
    private TextField tfCourseName = new TextField();
    private TextField tfTopic = new TextField();
    private TextArea tfDescription = new TextArea();
    private ComboBox drMenuBoxLevel = new ComboBox();
    private ComboBox drMenuBoxContentItem = new ComboBox();
    private Label courseName = new Label("Cursusnaam: ");
    private Label topic = new Label("Onderwerp: ");
    private Label description = new Label("Beschrijving: ");
    private Label level = new Label("Level: ");
    private Label Content = new Label("Content: ");
    private Button btnInsert = new Button("Toevoegen");
    private Button btnDelete = new Button("Verwijderen");
    private Button btnUpdate = new Button("Update");
    private Button backButton = new Button("Terug");


    //haalt alle courses op
    public void showCourse() {
        ObservableList<Course> courseTable = coursesController.getCourse();
        this.courseTable.refresh();
        this.cursusNameTable.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        this.subjectTable.setCellValueFactory(new PropertyValueFactory<>("Topic"));
        this.descriptionTable.setCellValueFactory(new PropertyValueFactory<>("Description"));
        this.levelTable.setCellValueFactory(new PropertyValueFactory<>("Level"));
        this.courseTable.setItems(courseTable);
    }
//test
    public Scene getView() {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        HBox hbox = new HBox();
        hbox.getChildren().setAll(this.btnInsert, this.btnUpdate, this.btnDelete);
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(20, 0, 0, 0));

        this.btnInsert.setOnAction((event) -> {
            if (drMenuBoxContentItem.getItems().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Selecteer een module!");

                alert.showAndWait();
            } else {
                this.insertRecord();
                this.insertCourseContent();
            }
        });
        this.btnUpdate.setOnAction((event) -> {
            if (event == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Kies een module!");

                alert.showAndWait();
            }else {
                this.updateRecord();
            }
        });
        this.btnDelete.setOnAction((event) -> this.deleteRecord());

        setCellValueFromTableToTextField();
        this.courseTable.getColumns().addAll(this.cursusNameTable, this.subjectTable, this.descriptionTable, this.levelTable);

        bp.setRight(this.courseTable);
        bp.setLeft(gridPane);
        this.showCourse();

        for (Level level : Level.values()) {
            drMenuBoxLevel.getItems().add(level);
        }

        for(ContentItems c: contentItemController.getContentItemList()){
            if (c.getModuleTitle() != null){
                this.drMenuBoxContentItem.getItems().add(c.getModuleTitle());
            }
        }

        gridPane.add(courseName, 0, 0);
        gridPane.add(tfCourseName, 1, 0);
        gridPane.add(topic, 0, 1);
        gridPane.add(tfTopic, 1, 1);
        gridPane.add(description, 0, 2);
        gridPane.add(tfDescription, 1, 2);
        gridPane.add(level, 0, 3);
        gridPane.add(drMenuBoxLevel, 1, 3);
        gridPane.add(Content, 0, 4);
        gridPane.add(drMenuBoxContentItem, 1, 4);
        gridPane.add(hbox, 0, 5);

        Scene scene = new Scene(bp);
        return scene;
    }

    //toevoeged de gegevens
    public void insertRecord() {
        String query = coursesController.addCourse(
                this.tfCourseName.getText(),
                this.tfTopic.getText(),
                this.tfDescription.getText(),
                this.drMenuBoxLevel.getValue().toString());
        db.executeQuery(query);
        this.showCourse();
    }

    public void insertCourseContent() {
        boolean is = this.drMenuBoxContentItem.getSelectionModel().is
        String query = coursesController.addContentCourse(
          this.drMenuBoxContentItem.getSelectionModel().getSelectedIndex() + 1,
          this.tfCourseName.getText());
        db.executeQuery(query);
        this.showCourse();
    }

    //Haalt de gegevens op van table en zet het in de kolomen neer
    public void setCellValueFromTableToTextField() {
        courseTable.setOnMouseClicked(e -> {
            Course p1 = courseTable.getItems().get(courseTable.getSelectionModel().getSelectedIndex());
            this.tfCourseName.setText(p1.getCourseName());
            this.tfTopic.setText(p1.getTopic());
            this.tfDescription.setText(p1.getDescription());
            this.drMenuBoxLevel.setValue(p1.getLevel().toString());
        });
    }

    private void deleteRecord() {
        //Controleer of er een record geselecteerd is.
        if (courseTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();
        }

        // Ophalen en vervolgens verwijderen van record a.d.h.v muisselectie
        else {
            TablePosition pos = courseTable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Course course = courseTable.getItems().get(row);

            String query = coursesController.makeDeleteQuery(course.getCourseName());
            this.db.executeQuery(query);
            this.showCourse();
        }
    }

    //update de gegevens
    public void updateRecord() {
        if (courseTable.getSelectionModel().getSelectedItem() == null) {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("Geen record geselecteerd");
            warningAlert.show();
        } else {
            String query = coursesController.updateCourse(
                    this.tfCourseName.getText(),
                    this.tfTopic.getText(),
                    this.tfDescription.getText(),
                    this.drMenuBoxLevel.getValue().toString());
            db.executeQuery(query);
            this.showCourse();
        }
    }
}
