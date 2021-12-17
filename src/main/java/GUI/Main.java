/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.database;

//Switch scene na index class
import Domain.Cursist;
import GUI.Student.index;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * @author quinc
 */
public class Main extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        GridPane gridPane = new GridPane();

        Button students = new Button("Studenten");
        Label titel = new Label("Welcome!");

        layout.setTop(titel);
        gridPane.add(students, 1, 1);
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        layout.setCenter(gridPane);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
//       database database = new database();
//       database.showCursisten();
        launch(Main.class);
    }
}
