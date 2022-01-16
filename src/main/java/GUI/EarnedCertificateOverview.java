package GUI;


import Database.EarnedCertificatesController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

//View 4: Voor een geselecteerd account, geef welke certificaten behaald zijn.

public class EarnedCertificateOverview {
    private EarnedCertificatesController ecController = new EarnedCertificatesController();

    private ComboBox accountMenuBox = new ComboBox();

    private Label accountLabel = new Label("Account: ");
    private Label descriptionlabel = new Label("Bekijk de behaalde certificaten van een gebruiker");
    private Label resultLabel = new Label("Certificaten: ");
    private Label results = new Label();
    private Button resultButton = new Button("Check");
    public Button backBtn = new Button("Terug");


    public Scene getView() {

        //borderpane met styligng
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));
        bp.setPrefSize(800, 300);
        BorderPane.setAlignment(this.resultButton, Pos.CENTER);
        BorderPane.setAlignment(this.descriptionlabel, Pos.CENTER);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(this.accountLabel, this.accountMenuBox, this.resultLabel, this.results);
        hbox.setSpacing(25);
        hbox.setAlignment(Pos.CENTER);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(this.backBtn, this.resultButton);
        hbox2.setSpacing(25);
        hbox2.setAlignment(Pos.CENTER);


        this.descriptionlabel.setFont(Font.font("Verdana", 20));
        this.results.setFont(Font.font("Verdana", 20));
        this.resultLabel.setFont(Font.font("Verdana", 20));
        this.resultButton.setOnAction((event) -> this.getCertificatesOfAccount());
        this.results.setText("");
        // Ingeschreven accounts ophalen en in dropdown menu zetten
        accountMenuBox.getItems().clear();
        for (String account : ecController.getListOfEnrolledAccounts()) {
            accountMenuBox.getItems().add(account);
        }

        bp.setTop(this.descriptionlabel);
        bp.setCenter(hbox);
        bp.setBottom(hbox2);


        //scene aanmaken en returnen
        Scene scene = new Scene(bp);
        return scene;
    }

    //Haalt alle behaalde certificaten op van het geselecteerde account en toont deze in een label.
    private void getCertificatesOfAccount() {
        ArrayList<String> certificateList = ecController.GetCertificatesOfAccount(accountMenuBox.getValue().toString());
        String result = "";
        for (String certificate : certificateList) {
            result += certificate + "\n";
        }
        this.results.setText(result);
    }
}
