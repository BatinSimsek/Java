package GUI;

import Database.CourseController;
import Database.StudentController;
import Database.EnrollController;
import Domain.Course;
import Domain.Student;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InschrijfMenu {
        public Button backBtn = new Button("Terug");
        private final Button enrollBtn = new Button("Inschrijven");
        private final Label introText = new Label("Schrijf je in!");

        private final Label mailText = new Label("* email: ");
        private final TextField mailTextField = new TextField();
        private final Label errorMail = new Label("");

        private Label courseName = new Label("* cursus: ");
        private ComboBox comboBox = new ComboBox();
        private final Label errorCourse = new Label("");

        StudentController cursistController = new StudentController();
        CourseController courseController = new CourseController();
        EnrollController enrollController = new EnrollController();


        private boolean availableEmail = false;
        private boolean selectedCourse = false;

        private Label titleCourse = new Label("Je hebt je ingeschreven voor: ");
        private Label nameCourseLabel = new Label("");
        private Label difficultyLabel = new Label("");
        private Label topicLabel = new Label("");

        private Button resetBtn = new Button("Reset");
        private Button confirmBtn = new Button("Confirm");

        private String nameCourse = "";
        private String difficulty = "";
        private String topic = "";

    public Scene getScene() {
        BorderPane mainPane = new BorderPane();
        GridPane userInputPane = getContent();
        GridPane selectedCourseGrid = getCourseInfoPane();

        mainPane.setCenter(userInputPane);
        getInfoAfterEnrollPane(mainPane, selectedCourseGrid);
        mainPane.snapSpaceY(10);
        Scene scene = new Scene(mainPane,600,600);
        return scene;
    }

    private void getInfoAfterEnrollPane(BorderPane mainPane, GridPane selectedCourseGrid) {
        enrollBtn.setOnAction(actionEvent -> {
            CheckIfMailAvailable();
            ChooseAvailableCourse();

            if (availableEmail && selectedCourse) {
                mainPane.setBottom(selectedCourseGrid);

                for (Course course : courseController.getCourse()) {
                    if (course.getCourse().equals(comboBox.getValue())) {
                        nameCourseLabel.setText(course.getCourse());
                        difficultyLabel.setText(course.getLevel());
                        topicLabel.setText(course.getTopic());
                        break;
                    }
                }
            }
        });
    }

    private GridPane getCourseInfoPane() {
        GridPane selectedCourseGrid = new GridPane();
        selectedCourseGrid.add(titleCourse,0,0);
        titleCourse.setFont(Font.font("Verdana",15));

        selectedCourseGrid.add(new Label("Naam cursus: "),0,1);
        selectedCourseGrid.add(nameCourseLabel,1,1);
        selectedCourseGrid.add(new Label("Onderwerp: "),0,2);
        selectedCourseGrid.add(topicLabel,1,2);
        selectedCourseGrid.add(new Label("Moeilijkheidsgraad: "),0,3);
        selectedCourseGrid.add(difficultyLabel,1,3);
        selectedCourseGrid.add(resetBtn,1,4);
        resetBtn.setOnAction(actionEvent -> {
            resetAllInput();
        });
        selectedCourseGrid.add(confirmBtn,2,4);
        confirmBtn.setOnAction(actionEvent -> {
            addEnrollmentToDataBase();
            resetAllInput();
        });


        selectedCourseGrid.setHgap(30);
        selectedCourseGrid.setVgap(30);
        selectedCourseGrid.setPadding(new Insets(50,50,50,50));
        return selectedCourseGrid;
    }

    private void resetAllInput() {
        availableEmail = false;
        selectedCourse = false;
        mailTextField.setText("");
        errorMail.setText("");
        errorCourse.setText("");
        nameCourseLabel.setText("");
        difficultyLabel.setText("");
        topicLabel.setText("");
    }

    private void addEnrollmentToDataBase() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String[] newDate = formatter.format(date).split("/");
        enrollController.makeInsertQuery(
                Integer.parseInt(newDate[0]),
                Integer.parseInt(newDate[1]),
                Integer.parseInt(newDate[2]),
                getRandomID(),
                nameCourseLabel.getText(),
                mailTextField.getText());
    }

    public int getRandomID() {
        Random random = new Random();
        return random.nextInt(9999);
    }

    private void ChooseAvailableCourse() {
        if (comboBox.getValue() == null) {
            errorCourse.setText("Kies een geldige cursus.");
        } else {
            selectedCourse = true;
            errorCourse.setText("cursus gevonden!");
        }
    }

    private void CheckIfMailAvailable() {
        for (Student student : cursistController.getCursistList()){
            if (student.getEmail().equals(mailTextField.getText())) {
                errorMail.setText("Email gevonden!");
                availableEmail = true;
                break;
            } else { errorMail.setText("Email niet gevonden in de database"); }
        }
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
        comboBox.getItems().clear();
        for (Course courses : courseController.getCourse()) {
            comboBox.getItems().add(courses.getCourse());
        }

        gridPane.add(backBtn,0,3);
        gridPane.add(enrollBtn,1,3);

        gridPane.setPadding(new Insets(50,50,50,50));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        return gridPane;
    }
}
