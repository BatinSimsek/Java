package GUI.Student;

import Domain.Cursist;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class index {


    public Scene getVıew() {

        BorderPane layouts = new BorderPane();
        GridPane gridLayout = new GridPane();

        TableColumn<Cursist, String> column1 = new TableColumn<>("email");
        Label label = new Label("test");
        layouts.setCenter(label);

        Scene scene = new Scene(layouts);



        return scene;
    }

}

