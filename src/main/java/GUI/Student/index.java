package GUI.Student;

import Domain.Cursist;
import GUI.Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class index {


    public Parent getVıew() {

        BorderPane layout = new BorderPane();
        GridPane gridLayout = new GridPane();

        TableColumn<Cursist, String> column1 = new TableColumn<>("email");


        return layout;
    }

}

