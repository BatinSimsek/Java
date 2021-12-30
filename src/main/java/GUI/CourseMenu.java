package GUI;

import Database.CourseController;
import Domain.Cursist;
import Domain.Level;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CourseMenu {
    private CourseController coursesController = new CourseController();
    private TableView<Cursist> cursistTable = new TableView<>();
    private TextField tfCourseName = new TextField();
    private TextField tfTopic = new TextField();
    private TextArea tfDescription = new TextArea();
    private ComboBox drMenuBox = new ComboBox();
    private Label courseName = new Label("Courses naam: ");
    private Label topic = new Label("Onderwerp: ");
    private Label description = new Label("Beschrijving: ");
    private Label level = new Label("Level: ");
    private Button btnInsert = new Button("Toevoegen");
    private Button btnDelete = new Button("Verwijderen");
    private Button btnUpdate = new Button("Update");

    public Scene makeCurist() {
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        HBox hbox = new HBox ();
        hbox.getChildren().setAll(this.btnInsert, this.btnUpdate, this.btnDelete);
        hbox.setSpacing(25);
        hbox.setPadding(new Insets(20, 0, 0 , 0));

        for (Level level : Level.values()) {
            drMenuBox.getItems().add(level);
        }


        bp.setLeft(gridPane);

        gridPane.add(courseName, 0, 0);
        gridPane.add(tfCourseName, 1, 0);
        gridPane.add(topic, 0 ,1);
        gridPane.add(tfTopic, 1, 1);
        gridPane.add(description, 0,2);
        gridPane.add(tfDescription, 1,2);
        gridPane.add(level, 0, 3);
        gridPane.add(drMenuBox, 1, 3);
        gridPane.add(hbox, 0, 4);

        Scene scene = new Scene(bp);
        return scene;
    }
}
