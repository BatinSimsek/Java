package GUI;

import Database.CompletedCourseController;
import Domain.Geslacht;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

//Voor een geselecteerd geslacht, geef aan voor hoeveel procent van de cursussen waarvoor ingeschreven is, het certificaat behaald is.

public class CompletedCourseOverview {
    private CompletedCourseController ccController = new CompletedCourseController();

    private ComboBox genderMenuBox = new ComboBox();

    private Label genderLabel = new Label("Geslacht: ");
    private Label descriptionlabel = new Label("Bekijk het percentage behaalde cursussen per geslacht");
    private Label resultLabel = new Label();
    private Button resultButton = new Button("Bereken");
    public Button backBtn = new Button("Terug");


    public Scene getView() {

        //borderpane met styligng
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));
        bp.setPrefSize(800, 300);
        BorderPane.setAlignment(this.resultButton, Pos.CENTER);
        BorderPane.setAlignment(this.descriptionlabel, Pos.CENTER);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(this.genderLabel, this.genderMenuBox, this.resultLabel);
        hbox.setSpacing(25);
        hbox.setAlignment(Pos.CENTER);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(this.backBtn, this.resultButton);
        hbox2.setSpacing(25);
        hbox2.setAlignment(Pos.CENTER);


        this.descriptionlabel.setFont(Font.font("Verdana", 20));
        this.resultLabel.setFont(Font.font("Verdana", 20));
        this.resultButton.setOnAction((event) -> this.calculateResult());

        // Enum geslachten ophalen en in dropdown menu zetten
        genderMenuBox.getItems().clear();
        for (Geslacht geslacht : Geslacht.values()) {
            genderMenuBox.getItems().add(geslacht);
        }

        bp.setTop(this.descriptionlabel);
        bp.setCenter(hbox);
        bp.setBottom(hbox2);
        //scene aanmaken en returnen
        Scene scene = new Scene(bp);
        return scene;
    }


    // deze methode haalt het totaal aantal inschrijving en het toaal behaalde certificaten van één geslacht op ren rekent het om naar een percentage.
    private void calculateResult() {
        String gender = this.genderMenuBox.getValue().toString();
        int totalEnrollments = ccController.getTotalEnrollmentsOfGender(gender);
        int totalCertificates = ccController.getTotalCertificatesOfGender(gender);
        double percentage = ((double) totalCertificates / totalEnrollments) * 100;
        double result = Math.round(percentage * 100.0) / 100.0;
        resultLabel.setText(result + "%");
    }


}
