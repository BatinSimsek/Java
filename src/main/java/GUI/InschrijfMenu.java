package GUI;

import Database.CourseController;
import Database.CursistController;
import Domain.Cursist;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class InschrijfMenu {
        public Button backBtn = new Button("Back");
        private final Button enrollBtn = new Button("Enroll now");
        private final Label introText = new Label("Enroll here!");

        private final Label mailText = new Label("* Your mail: ");
        private final TextField mailTextField = new TextField();
        private final Label errorMail = new Label("");

        private Label courseName = new Label("* Choose Course: ");
        private ComboBox comboBox = new ComboBox();
        private final Label errorCourse = new Label("");

        CursistController cursistController = new CursistController();
        CourseController courseController = new CourseController();

        private boolean availableEmail = false;
        private boolean selectectedCourse = false;

        private Label titleCourse = new Label("You have signed up for: ");
        private Label nameCourseLabel = new Label("");
        private Label difficultyLabel = new Label("");
        private Label topicLabel = new Label("");

        private Button resetBtn = new Button("Reset");
        private Button confirmBtn = new Button("Confirm");
    public Scene getScene() {
        BorderPane mainPane = new BorderPane();
        GridPane userInputPane = getContent();
        GridPane selectedCourseGrid = getCourseInfoPane();


        getEnrollButtonAction();

        mainPane.setCenter(userInputPane);
        mainPane.setBottom(selectedCourseGrid);
        mainPane.snapSpaceY(10);
        Scene scene = new Scene(mainPane,600,600);
        return scene;
    }



    private GridPane getCourseInfoPane() {
        GridPane selectedCourseGrid = new GridPane();
        selectedCourseGrid.add(titleCourse,0,0);
        titleCourse.setFont(Font.font("Verdana",15));

        selectedCourseGrid.add(new Label("Name course: "),0,1);
        selectedCourseGrid.add(nameCourseLabel,1,1);
        selectedCourseGrid.add(new Label("Topic: "),0,2);
        selectedCourseGrid.add(topicLabel,1,2);
        selectedCourseGrid.add(new Label("Difficulty: "),0,3);
        selectedCourseGrid.add(difficultyLabel,1,3);
        selectedCourseGrid.add(resetBtn,1,4);
        selectedCourseGrid.add(confirmBtn,2,4);


        selectedCourseGrid.setHgap(30);
        selectedCourseGrid.setVgap(30);
        selectedCourseGrid.setPadding(new Insets(50,50,50,50));
        return selectedCourseGrid;
    }

    private void getEnrollButtonAction() {
        enrollBtn.setOnAction(actionEvent -> {
            for (Cursist cursist : cursistController.getCursistList()){
                if (cursist.getEmail().equals(mailTextField.getText())) {
                    errorMail.setText("Email found!");
                    availableEmail = true;
                    break;
                } else { errorMail.setText("Email not found, Please sign up first"); }
            }

            if (comboBox.getValue() == null) {
                errorCourse.setText("Please select a available course.");
            } else {
                selectectedCourse = true;
                errorCourse.setText("Course found!");
            }
        });
    }


    private GridPane getContent() {
        GridPane gridPane = new GridPane();
        gridPane.add(introText,0,0);
        introText.setFont(Font.font("Verdana",15));

        gridPane.add(mailText,0,1);
        gridPane.add(mailTextField,1,1);
        gridPane.add(errorMail,2,1);

        gridPane.add(courseName,0,2);
        gridPane.add(comboBox,1,2);
        gridPane.add(errorCourse,2,2);
        comboBox.setPrefWidth(150);
//        comboBox.setItems(CourseController.getObservableList);
        comboBox.getItems().add("test");

        gridPane.add(backBtn,0,3);
        gridPane.add(enrollBtn,1,3);

        gridPane.setPadding(new Insets(50,50,50,50));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        return gridPane;
    }
}
