package GUI;


import Database.AmmountPassedCourseController;
import Database.CompletedCourseController;
import Domain.Geslacht;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class AmmountPassedCourseView {
    private AmmountPassedCourseController apcController = new AmmountPassedCourseController();

    private ComboBox courseMenuBox = new ComboBox();

    private Label courseLabel = new Label("Course: ");
    private Label descriptionlabel = new Label("Bekijk hoe vaak een cursus behaald is");
    private Label resultLabel = new Label();
    private Button resultButton = new Button("Check");
    public Button backBtn = new Button("Terug");

    // deze menthode maakt de view (8) met daarin de mogelijkheid om te bekijken hoe vaak cursus behaald is.
    public Scene getView() {

        //borderpane met styligng
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));
        bp.setPrefSize(800, 300);
        BorderPane.setAlignment(this.resultButton, Pos.CENTER);
        BorderPane.setAlignment(this.descriptionlabel, Pos.CENTER);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(this.courseLabel, this.courseMenuBox, this.resultLabel);
        hbox.setSpacing(25);
        hbox.setAlignment(Pos.CENTER);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(this.backBtn, this.resultButton);
        hbox2.setSpacing(25);
        hbox2.setAlignment(Pos.CENTER);

        this.resultLabel.setText("");
        this.descriptionlabel.setFont(Font.font("Verdana", 20));
        this.resultLabel.setFont(Font.font("Verdana", 20));
        this.resultButton.setOnAction((event) -> this.getAmmountOfCourseCompletion());

        // Enum course namen op te halen en in dropdown menu zetten
        courseMenuBox.getItems().clear();
        for (String course : apcController.getCourses()) {
            courseMenuBox.getItems().add(course);
        }

        bp.setTop(this.descriptionlabel);
        bp.setCenter(hbox);
        bp.setBottom(hbox2);
        //scene aanmaken en returnen
        Scene scene = new Scene(bp);
        return scene;
    }


    // deze methode checkt hoe vaak een cursus behaald is.
    private void getAmmountOfCourseCompletion() {
        String course = this.courseMenuBox.getValue().toString();
        int timesCompleted = apcController.getAmmountOfCourseCompleted(course);
        resultLabel.setText(String.valueOf(timesCompleted));
    }

}
