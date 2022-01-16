package GUI;

import Database.EarnedCertificatesController;
import Database.TopThreeWebcastController;
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

public class TopThreeWebcastOverview {

    private TopThreeWebcastController webcastController = new TopThreeWebcastController();


    private Label descriptionlabel = new Label("Top 3 webcast");
    private Label results = new Label();
    public Button backBtn = new Button("Terug");


    public Scene getView() {
        //borderpane met styligng
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25, 25, 25, 25));
        bp.setPrefSize(800, 300);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(this.results);
        hbox.setSpacing(25);
        hbox.setAlignment(Pos.CENTER);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(this.backBtn);
        hbox2.setSpacing(25);
        hbox2.setAlignment(Pos.CENTER);


        this.descriptionlabel.setFont(Font.font("Verdana", 20));
        this.results.setFont(Font.font("Verdana", 20));
        topWebcast();

        bp.setTop(this.descriptionlabel);
        bp.setCenter(hbox);
        bp.setBottom(hbox2);


        //scene aanmaken en returnen
        Scene scene = new Scene(bp);
        return scene;
    }

    //laat de top 3 zien
    public void topWebcast() {
        ArrayList<String> webcast = webcastController.getTopThreeWebcast();
        String result = "";
        for (String certificate : webcast) {
            result += certificate + "\n";
        }
        this.results.setText(result);
    }
}
