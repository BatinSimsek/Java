package GUI;

import Database.ModuleProgressionController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class ModuleProgressionOverview {
    private ModuleProgressionController mpController = new ModuleProgressionController();

    private ComboBox accountBox = new ComboBox();
    private ComboBox courseBox = new ComboBox();

    private Label accountLabel = new Label("Account: ");
    private Label courseLabel = new Label("Courses: ");
    private Label descriptionlabel = new Label("Progessie bekijken van module per account.");
    private Label resultLabel = new Label();
    private Button resultButton = new Button("Check");
    private Button getCourseButton = new Button("Get Course");
    public Button backBtn = new Button("Terug");

    public Scene getView() {
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));
        bp.setPrefSize(800, 300);
        BorderPane.setAlignment(this.resultButton, Pos.CENTER);
        BorderPane.setAlignment(this.descriptionlabel, Pos.CENTER);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(this.accountLabel, this.accountBox, this.getCourseButton, this.courseLabel, this.courseBox, this.resultLabel);
        hbox.setSpacing(25);
        hbox.setAlignment(Pos.CENTER);


        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(this.backBtn, this.resultButton);
        hbox2.setSpacing(25);
        hbox2.setAlignment(Pos.CENTER);


        this.resultLabel.setText("");
        this.descriptionlabel.setFont(Font.font("Verdana", 20));
        this.resultLabel.setFont(Font.font("Verdana", 20));
        this.resultButton.setOnAction((event) -> this.getModuleProgression());
        courseBox.getItems().clear();
        this.getCourseButton.setOnAction((event) -> {
            courseBox.getItems().clear();
            for (String courses : mpController.getCoursesFromAccount(this.accountBox.getValue().toString())) {
                courseBox.getItems().add(courses);
            }
        });
        accountBox.getItems().clear();
        for (String account : mpController.getEnrolledAccount()) {
            accountBox.getItems().add(account);
        }


        bp.setTop(this.descriptionlabel);
        bp.setCenter(hbox);
        bp.setBottom(hbox2);

        Scene scene = new Scene(bp);
        return scene;
    }


    public void getModuleProgression() {
        HashMap<String, Integer> moduleProgression = mpController.getModuleProgression(this.accountBox.getValue().toString(), this.courseBox.getValue().toString());
        String result = "";
        for (String name : moduleProgression.keySet()) {
            String key = name.toString();
            String value = moduleProgression.get(name).toString();

            result += key + " " + value + "%\n";
        }

        this.resultLabel.setText(result);

    }
}
